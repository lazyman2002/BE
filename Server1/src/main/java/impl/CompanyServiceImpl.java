package impl;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.CompanyController;
import org.controller.Converter;
import org.model.Companies;
import proto.CompanyServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class CompanyServiceImpl extends CompanyServiceGrpc.CompanyServiceImplBase {
    @Override
    public void companyListRead(Empty request, StreamObserver<ServerClient.CompanyFullInfo> responseObserver) {
        System.out.println("companyListRead");
        try {
            CompanyController companyController = new CompanyController();
            ArrayList<Companies> companies = new ArrayList<>(companyController.companyList());

            for (Companies company : companies) {
                ServerClient.CompanyFullInfo companyInfo = Converter.companiesToProto(company);
                responseObserver.onNext(companyInfo);
            }
            responseObserver.onCompleted();
        }
        catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void companyReadInfo(ServerClient.CompanyFullInfo request, StreamObserver<ServerClient.CompanyFullInfo> responseObserver) {
        System.out.println("companyReadInfo");
        try{
            CompanyController companyController = new CompanyController();
            Companies company = companyController.companyRead(request);
            responseObserver.onNext(Converter.companiesToProto(company));
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void companyRegister(ServerClient.CompanyFullInfo request, StreamObserver<ServerClient.CompanyFullInfo> responseObserver) {
        System.out.println("companyReadInfo");
        try {
            CompanyController companyController = new CompanyController();
            Companies companies = companyController.companyRegister(request);
            responseObserver.onNext(Converter.companiesToProto(companies));
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }

    }

    @Override
    public void companyUpdateInfo(ServerClient.CompanyFullInfo request, StreamObserver<ServerClient.CompanyFullInfo> responseObserver) {
        System.out.println("companyUpdateInfo");
        try {
            CompanyController companyController = new CompanyController();
            Companies companies = companyController.companyUpdate(request);
            responseObserver.onNext(Converter.companiesToProto(companies));
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void companyDelete(ServerClient.CompanyFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("companyDelete");
        try {
            CompanyController companyController = new CompanyController();
            Boolean bool = companyController.companyDelete(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(bool).build());
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
