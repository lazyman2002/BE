package org.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hadoop.HadoopService;
import impl.ChatServiceImpl;
import impl.GroupServiceImpl;
import impl.ScheduleServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.connectConfig.ENVDockers;
import static spark.Spark.*;

import java.io.IOException;
import java.util.List;

import io.grpc.protobuf.services.ProtoReflectionService;
import proto.ServerChat;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start Server");
        Server server = ServerBuilder.forPort(ENVDockers.gRPC_port)
                .addService(new ChatServiceImpl())
                .addService(new GroupServiceImpl())
                .addService(new ScheduleServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
        port(19092);
        get("/oldchat/:groupID", (req, res) -> {
            try {
                Integer groupID = Integer.parseInt(req.params(":groupID"));
                HadoopService hadoopService = new HadoopService();
                List<ServerChat.MessageInfo> MSG = hadoopService.getMessagesByGroupID(groupID);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonResponse = gson.toJson(MSG);
                res.type("application/json");
                return jsonResponse;
            }
            catch (Exception e){
                return e.toString();
            }
        });
        server.awaitTermination();
    }
}