package org.app;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.connectConfig.ENVDockers;
import org.proto.CompanyServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start Server3");
        Server server = ServerBuilder.forPort(ENVDockers.gRPC_port)
                .addService(new CompanyServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }
}