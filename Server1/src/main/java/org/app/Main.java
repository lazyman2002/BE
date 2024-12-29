package org.app;

import impl.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.connectConfig.ENVDockers;

import java.io.IOException;

import io.grpc.protobuf.services.ProtoReflectionService;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start Server");
        Server server = ServerBuilder.forPort(ENVDockers.gRPC_port)
                .addService(new UserServiceImpl())
                .addService(new CompanyServiceImpl())
                .addService(new RoleServiceImpl())
                .addService(new JobRequestServiceImpl())
                .addService(new LocationServiceImpl())

                .addService(new CertificationServiceImpl())
                .addService(new EducationServiceImpl())
                .addService(new PersonalityServiceImpl())
                .addService(new SkillServiceImpl())
                .addService(new WorkExperienceServiceImpl())
                .addService(new CVServiceImpl())
                .addService(new SearchServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
        server.awaitTermination();
    }
}