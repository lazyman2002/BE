package impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.CertificationController;
import org.controller.Converter;
import org.model.Certifications;
import proto.CertificationServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class CertificationServiceImpl extends CertificationServiceGrpc.CertificationServiceImplBase {
    @Override
    public void certificationListRead(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.CertificationFullInfo> responseObserver) {
        System.out.println("certificationListRead");

        CertificationController certificationController = new CertificationController();
        try {
            ArrayList<Certifications> certifications = certificationController.certificationList(request);
            System.out.println(certifications);
            for (Certifications certification : certifications) {
                ServerClient.CertificationFullInfo certificationFullInfo = Converter.certificationsToFullProto(certification);
                responseObserver.onNext(certificationFullInfo);
            }
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void certificationRead(ServerClient.CertificationFullInfo request, StreamObserver<ServerClient.CertificationFullInfo> responseObserver) {
        System.out.println("certificationRead");

        try {
            CertificationController certificationController = new CertificationController();
            Certifications certification = certificationController.certificationRead(request);
            responseObserver.onNext(Converter.certificationsToFullProto(certification));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void certificationUpdateInfo(ServerClient.CertificationFullInfo request, StreamObserver<ServerClient.CertificationFullInfo> responseObserver) {
        System.out.println("certificationUpdateInfo");

        try {
            CertificationController certificationController = new CertificationController();
            Certifications certification = certificationController.certificationUpdate(request);
            responseObserver.onNext(Converter.certificationsToFullProto(certification));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void certificationCreate(ServerClient.CertificationFullInfo request, StreamObserver<ServerClient.CertificationFullInfo> responseObserver) {
        System.out.println("certificationCreate");

        try {
            CertificationController certificationController = new CertificationController();
            Certifications certification = certificationController.certificationRegister(request);
            responseObserver.onNext(Converter.certificationsToFullProto(certification));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void certificationDelete(ServerClient.CertificationFullInfo request, StreamObserver<ServerClient.Answer> responseObserver) {
        System.out.println("certificationDelete");

        try {
            CertificationController certificationController = new CertificationController();
            Boolean bool = certificationController.certificationDelete(request);
            responseObserver.onNext(ServerClient.Answer.newBuilder().setAnsBool(bool).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
