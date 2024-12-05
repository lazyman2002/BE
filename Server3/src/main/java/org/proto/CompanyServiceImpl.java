package org.proto;

import io.grpc.stub.StreamObserver;
import org.DAO.CompaniesDAO;
import org.controller.Converters;
import org.controller.RegisterCompany;
import org.model.Companies;

public class CompanyServiceImpl extends CompanyServiceGrpc.CompanyServiceImplBase{
    @Override
    public void companyRegister(Server3.CompanyFullInfo request, StreamObserver<Server3.CompanyFullInfo> responseObserver) {

//        Truy cập vào controllers
        RegisterCompany registerCompany = new RegisterCompany();
        registerCompany.registerCompany(request);

//        Gửi dữ liệu
        responseObserver.onNext(Server3.CompanyFullInfo.newBuilder()
                .setCompanyName(request.getCompanyName())
                .setCompanyAvatarURL(request.getCompanyAvatarURL())
                .setWebsite(request.getWebsite())
                .setEmail(request.getEmail())
                .build());
        responseObserver.onCompleted();
    }
}
