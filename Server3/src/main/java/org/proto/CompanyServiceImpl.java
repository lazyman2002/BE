package org.proto;

import io.grpc.stub.StreamObserver;

public class CompanyServiceImpl extends CompanyServiceGrpc.CompanyServiceImplBase{
    @Override
    public void companyRegister(Server3.CompanyFullInfo request, StreamObserver<Server3.CompanyFullInfo> responseObserver) {
        responseObserver.onNext(Server3.CompanyFullInfo.newBuilder()
                        .setCompanyName(request.getCompanyName())
                        .setCompanyAvatarURL(request.getCompanyAvatarURL())
                        .setWebsite(request.getWebsite())
                        .setEmail(request.getEmail())
                        .build());
        responseObserver.onCompleted();
    }
}
