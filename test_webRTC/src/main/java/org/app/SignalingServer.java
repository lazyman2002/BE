package org.app;

import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.json.JSONObject;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SignalingServer extends WebSocketServer {
    private final ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<WebSocket, String> connectionToRoomMap = new ConcurrentHashMap<>();

    public SignalingServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // Retrieve RoomId and Role from the URL query parameters
        String uri = conn.getResourceDescriptor();  // Get the URI of the WebSocket request
        String role = uri.split("&")[0].split("=")[1]; // Extract the roomId from query parameters
        String roomId = uri.split("&")[1].split("=")[1]; // Extract the role from query parameters

        System.out.println("Handshake received: RoomId=" + roomId + ", Role=" + role);
        if (roomId == null || role == null) {
//            conn.send("Missing RoomId or Role in handshake");
            conn.close(4000, "Missing RoomId or Role");
            return;
        }

        if (!rooms.containsKey(roomId)) {
            rooms.put(roomId, new Room(roomId));
        }

        Room room = rooms.get(roomId);
        connectionToRoomMap.put(conn, roomId);

        if ("recruiter".equals(role)) {
            if (room.recruiter == null) {
                room.recruiter = conn;
//                conn.send("Welcome, recruiter! You are in the interview room.");
                System.out.println("Recruiter connected to room " + roomId + ": " + conn.getRemoteSocketAddress());
            } else {
//                conn.send("Sorry, the recruiter slot is already occupied in this room.");
                conn.close(4000, "Room full for recruiters");
            }
        }
        else if ("candidate".equals(role)) {
            if (room.recruiter != null) {
                room.waitingRoom.add(conn);
//                conn.send("You are in the interview room for room " + roomId + ". Start your interview.");
                System.out.println("Candidate entered interview room in room " + roomId + ": " + conn.getRemoteSocketAddress());
            } else {
                room.waitingRoom.add(conn);
//                conn.send("You are in the waiting room for room " + roomId + ". Please wait for your turn.");
                System.out.println("Candidate added to waiting room in room " + roomId + ": " + conn.getRemoteSocketAddress());
            }
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        String roomId = connectionToRoomMap.get(conn);
        if (roomId != null) {
            Room room = rooms.get(roomId);
            if (conn == room.recruiter) {
                room.recruiter = null;
                System.out.println("Recruiter left room, checking waiting room...");
                if (!room.waitingRoom.isEmpty()) {
                    WebSocket nextCandidate = room.waitingRoom.poll();
//                    nextCandidate.send("The recruiter is now available. You can enter the room.");
                    System.out.println("Candidate moved from waiting room to interview in room " + room.roomId + ": " + nextCandidate.getRemoteSocketAddress());
                }
            }
            else {
                room.waitingRoom.remove(conn);
                System.out.println("Candidate left room " + room.roomId + ": " + conn.getRemoteSocketAddress());
            }
            connectionToRoomMap.remove(conn);  // Remove the connection from the map when it closes
        }

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        String roomId = connectionToRoomMap.get(conn);
        Room room = rooms.get(roomId);
        if (room == null) return;

        try {
            JSONObject jsonMessage = new JSONObject(message);
            String type = jsonMessage.getString("type");

            switch (type) {
                case "offer":
                    if (conn == room.recruiter) {
                        // Recruiter gửi "offer" -> chuyển cho candidate đầu tiên
                        if (!room.waitingRoom.isEmpty()) {
                            WebSocket candidate = room.waitingRoom.peek();
                            candidate.send(message); // Chuyển tiếp "offer"
                            System.out.println("Offer chuyển cho candidate: " + candidate.getRemoteSocketAddress());
                        }
                    }
                    break;

                case "answer":
                    if (conn != room.recruiter) {
                        // Candidate gửi "answer" -> chuyển cho recruiter
                        room.recruiter.send(message);
                        System.out.println("Answer chuyển cho recruiter: " + room.recruiter.getRemoteSocketAddress());
                    }
                    break;

                case "candidate":
                    // Chuyển tiếp ICE Candidate
                    if (conn == room.recruiter) {
                        for (WebSocket candidate : room.waitingRoom) {
                            candidate.send(message); // Gửi cho tất cả các candidate
                        }
                    } else {
                        room.recruiter.send(message); // Gửi cho recruiter
                    }
                    break;

                default:
                    System.out.println("Loại message không được hỗ trợ: " + type);
            }
        } catch (Exception e) {
            System.err.println("Lỗi phân tích JSON: " + e.getMessage());
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
    }

    public static void main(String[] args) {
        int port = 5000;
        SignalingServer server = new SignalingServer(port);
        server.start();
        System.out.println("Signaling server started on port: " + port);
    }

    static class Room {
        String roomId;
        WebSocket recruiter;
        ConcurrentLinkedQueue<WebSocket> waitingRoom = new ConcurrentLinkedQueue<>();

        public Room(String roomId) {
            this.roomId = roomId;
        }
    }
}
