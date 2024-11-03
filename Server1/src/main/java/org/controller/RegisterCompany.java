package org.controller;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.connectConfig.ENVDockers;
import org.model.Companies;
import org.proto.CompanyServiceGrpc;
import org.proto.CompanyServiceImpl;
import org.proto.Server3;
import spark.Request;
import spark.Response;

public class RegisterCompany {
    public Companies registerCompany (Request req, Response res){
        System.out.println("registerCompany");
        Converters converters = new Converters();
        Companies company = converters.ReqToCompanies(req);
//        Server3.CompanyFullInfo companyFullInfo = converters.CompaniesToProto(company);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(ENVDockers.spark_worker1_ip, ENVDockers.gRPC_port)
                .usePlaintext()
                .build();
        CompanyServiceGrpc.CompanyServiceBlockingStub stub = CompanyServiceGrpc.newBlockingStub(channel);

        Server3.CompanyFullInfo companyRegister = stub.companyRegister(Server3.CompanyFullInfo.newBuilder()
                .setCompanyName(company.getCompanyName())
                .setCompanyAvatarURL(company.getCompanyAvatarURL())
                .setWebsite(company.getWebsite())
                .setEmail(company.getEmail())
                .build());
        System.out.println("Registering" + companyRegister.getCompanyName());
        return null;
    }
}
