package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.EducationController;
import org.controller.Converter;
import org.model.Educations;
import proto.EducationServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class EducationServiceImpl extends EducationServiceGrpc.EducationServiceImplBase {
    @Override
    public void educationListRead(ServerClient.CVFullInfo request, StreamObserver<ServerClient.EducationFullInfo> responseObserver) {
        System.out.println("educationListRead");

        EducationController educationController = new EducationController();
        try {
            ArrayList<Educations> educations = educationController.educationList(request);
            System.out.println(educations);
            for (Educations education : educations) {
                ServerClient.EducationFullInfo educationFullInfo = Converter.educationsToFullProto(education);
                responseObserver.onNext(educationFullInfo);
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
    public void educationRead(ServerClient.EducationFullInfo request, StreamObserver<ServerClient.EducationFullInfo> responseObserver) {
        System.out.println("educationRead");

        try {
            EducationController educationController = new EducationController();
            Educations education = educationController.educationRead(request);
            responseObserver.onNext(Converter.educationsToFullProto(education));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void educationUpdateInfo(ServerClient.EducationFullInfo request, StreamObserver<ServerClient.EducationFullInfo> responseObserver) {
        System.out.println("educationUpdateInfo");

        try {
            EducationController educationController = new EducationController();
            Educations education = educationController.educationUpdate(request);
            responseObserver.onNext(Converter.educationsToFullProto(education));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void educationCreate(ServerClient.EducationFullInfo request, StreamObserver<ServerClient.EducationFullInfo> responseObserver) {
        System.out.println("educationCreate");

        try {
            EducationController educationController = new EducationController();
            Educations education = educationController.educationRegister(request);
            responseObserver.onNext(Converter.educationsToFullProto(education));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void educationDelete(ServerClient.EducationFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("educationDelete");

        try {
            EducationController educationController = new EducationController();
            Boolean bool = educationController.educationDelete(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(bool).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
