package org.controller;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.connectConfig.ENVDockers;
import org.model.Companies;
import spark.Request;
import spark.Response;

public class UpdateCompany {
    public Companies updateCompany (Request req, Response res){
        System.out.println("updateCompany");
        Converters converters = new Converters();
        Companies company = converters.ReqToCompanies(req);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(ENVDockers.spark_worker1_ip, ENVDockers.gRPC_port)
                .usePlaintext()
                .build();
    }
}
