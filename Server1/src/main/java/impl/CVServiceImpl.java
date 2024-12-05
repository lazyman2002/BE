package impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.CVController;
import org.controller.CertificationController;
import org.controller.Converter;
import org.model.CVs;
import proto.CVServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class CVServiceImpl extends CVServiceGrpc.CVServiceImplBase {
    @Override
    public void cVListRead(ServerClient.UserMetaInfo request, StreamObserver<ServerClient.CVFullInfo> responseObserver) {
        System.out.println("cvListRead");

        CVController cvController = new CVController();
        try {
            ArrayList<CVs> cvs = cvController.cvList(request);
            System.out.println(cvs);
            for (CVs cv : cvs) {
                ServerClient.CVFullInfo cvFullInfo = Converter.CVToFullProto(cv);
                responseObserver.onNext(cvFullInfo);
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
    public void cVRead(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.CVFullInfo> responseObserver) {
        System.out.println("cvReadInfo");

        try {
            CVController cvController = new CVController();
            CVs cv = cvController.cvRead(request);
            CertificationController certificationController = new CertificationController();

            responseObserver.onNext(Converter.CVToFullProto(cv));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void cVUpdateInfo(ServerClient.CVFullInfo request, StreamObserver<ServerClient.CVFullInfo> responseObserver) {
        System.out.println("cvUpdateInfo");

        try {
            CVController cvController = new CVController();
            CVs cv = cvController.cvUpdate(request);
            responseObserver.onNext(Converter.CVToFullProto(cv));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void cVCreate(ServerClient.CVFullInfo request, StreamObserver<ServerClient.CVFullInfo> responseObserver) {
        System.out.println("cvRegister");

        try {
            CVController cvController = new CVController();
            CVs cv = cvController.cvRegister(request);
            responseObserver.onNext(Converter.CVToFullProto(cv));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void cVDelete(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.Answer> responseObserver) {
        System.out.println("cvDeleteInfo");

        try {
            CVController cvController = new CVController();
            Boolean bool = cvController.cvDelete(request);
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