package org.app;

import impl.ChatServiceImpl;
import impl.GroupServiceImpl;
import impl.ScheduleServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.connectConfig.ENVDockers;
import static spark.Spark.*;

import java.io.IOException;

import io.grpc.protobuf.services.ProtoReflectionService;

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
        get("hello", (req, res) -> {
            return "hello";
        });
        server.awaitTermination();
    }
}