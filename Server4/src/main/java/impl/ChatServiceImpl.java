package impl;

import com.google.protobuf.BoolValue;
import hadoop.HadoopService;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.GroupController;
import proto.ChatServiceGrpc;
import proto.ServerChat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
    private static LinkedHashSet<StreamObserver<ServerChat.MessageInfo>> observers = new LinkedHashSet();
    Map<Integer, List<StreamObserver<ServerChat.MessageInfo>>> groupObservers = new ConcurrentHashMap<>();

    @Override
    public StreamObserver<ServerChat.MessageInfo> chat(StreamObserver<ServerChat.MessageInfo> responseObserver) {
        observers.add(responseObserver);
        GroupController groupController = new GroupController();

        return new StreamObserver<ServerChat.MessageInfo>() {
            private int userId;
            private int groupId;
            @Override
            public void onNext(ServerChat.MessageInfo messageInfo) {
                groupId = messageInfo.getToGroupID();
                userId = messageInfo.getFromUserID();

                Boolean legal = false;
                try {
                    legal = groupController.checkInGroup(userId, groupId);
                } catch (Exception e) {
                    responseObserver.onError(new IllegalArgumentException("User not in group"));
                }
                if (!legal) {
                    responseObserver.onError(new IllegalArgumentException("User not in group"));
                    return;
                }

                groupObservers.putIfAbsent(groupId, new CopyOnWriteArrayList<>());

                List<StreamObserver<ServerChat.MessageInfo>> grouper = groupObservers.get(groupId);

                if (!grouper.contains(responseObserver)) {
//Tải và gửi tin nhắn cũ

                    grouper.add(responseObserver);
                }
//Lưu giữ tin nhắn vào Kafka rồi mới vào các bên khác
                ServerChat.MessageInfo response = ServerChat.MessageInfo.newBuilder()
                        .setFromUserID(userId)
                        .setToGroupID(groupId)
                        .setMessengerData(messageInfo.getMessengerData())
                        .build();
                grouper.stream().forEach(o -> {o.onNext(response);});
            }

            @Override
            public void onError(Throwable throwable) {
                observers.remove(responseObserver);
            }

            @Override
            public void onCompleted() {
                observers.remove(responseObserver);
            }
        };
    }

    @Override
    public StreamObserver<ServerChat.Chunk> uploadFile(StreamObserver<BoolValue> responseObserver) {
        return new StreamObserver<ServerChat.Chunk>() {
            private final String uniqueId = UUID.randomUUID().toString();
            private final String tempFilePath = "temp_" + uniqueId + ".bin";
            private FileOutputStream fileOutputStream;

            {
                try {
                    fileOutputStream = new FileOutputStream(tempFilePath);
                } catch (IOException e) {
                    responseObserver.onError(new RuntimeException("Failed to create temporary file.", e));
                }
            }

            @Override
            public void onNext(ServerChat.Chunk chunk) {
                try {
                    fileOutputStream.write(chunk.getContent().toByteArray());
                } catch (IOException e) {
                    responseObserver.onError(new RuntimeException("Failed to write chunk to file.", e));
                }
            }

            @Override
            public void onError(Throwable t) {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    Files.deleteIfExists(Paths.get(tempFilePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.err.println("Upload failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }

                    String finalFilePath = "uploads/" + uniqueId + ".bin";
                    File uploadsDir = new File("uploads");
                    if (!uploadsDir.exists()) {
                        uploadsDir.mkdir();
                    }
                    Files.move(Paths.get(tempFilePath), Paths.get(finalFilePath));

                    System.out.println("File uploaded successfully: " + finalFilePath);

                    // Notify the client
                    responseObserver.onNext(BoolValue.of(true));
                    responseObserver.onCompleted();

                    // Save the uniqueId and file path to your database here
//                    HadoopService.uploadFile(uniqueId, finalFilePath);
                } catch (IOException e) {
                    responseObserver.onError(new RuntimeException("Failed to complete file upload.", e));
                }
            }
        };
    }

    @Override
    public void downloadFile(ServerChat.FileInfo request, StreamObserver<ServerChat.Chunk> responseObserver) {
        super.downloadFile(request, responseObserver);
    }

    @Override
    public void getOldChat(ServerChat.GroupInfo request, StreamObserver<ServerChat.MessageInfo> responseObserver) {
        try {
            HadoopService hadoopService = new HadoopService();
            List<ServerChat.MessageInfo> MSG = hadoopService.getMessagesByGroupID(request.getGroupID());
            for (ServerChat.MessageInfo msg  : MSG){
                responseObserver.onNext(msg);
            }
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
