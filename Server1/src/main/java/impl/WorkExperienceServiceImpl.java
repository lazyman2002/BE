package impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.WorkExperienceController;
import org.controller.Converter;
import org.model.WorkExperiences;
import proto.ServerClient;
import proto.WorkExperienceServiceGrpc;

import java.util.ArrayList;

public class WorkExperienceServiceImpl extends WorkExperienceServiceGrpc.WorkExperienceServiceImplBase {
    @Override
    public void workExperienceListRead(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.WorkExperienceFullInfo> responseObserver) {
        System.out.println("workExperienceListRead");

        WorkExperienceController workExperienceController = new WorkExperienceController();
        try {
            ArrayList<WorkExperiences> workExperiences = workExperienceController.workExperienceList(request);
            System.out.println(workExperiences);
            for (WorkExperiences workExperience : workExperiences) {
                ServerClient.WorkExperienceFullInfo workExperienceFullInfo = Converter.workExpToFullProto(workExperience);
                responseObserver.onNext(workExperienceFullInfo);
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
    public void workExperienceRead(ServerClient.WorkExperienceFullInfo request, StreamObserver<ServerClient.WorkExperienceFullInfo> responseObserver) {
        System.out.println("workExperienceRead");

        try {
            WorkExperienceController workExperienceController = new WorkExperienceController();
            WorkExperiences workExperience = workExperienceController.workExperienceRead(request);
            responseObserver.onNext(Converter.workExpToFullProto(workExperience));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void workExperienceUpdateInfo(ServerClient.WorkExperienceFullInfo request, StreamObserver<ServerClient.WorkExperienceFullInfo> responseObserver) {
        System.out.println("workExperienceUpdateInfo");

        try {
            WorkExperienceController workExperienceController = new WorkExperienceController();
            WorkExperiences workExperience = workExperienceController.workExperienceUpdate(request);
            responseObserver.onNext(Converter.workExpToFullProto(workExperience));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void workExperienceCreate(ServerClient.WorkExperienceFullInfo request, StreamObserver<ServerClient.WorkExperienceFullInfo> responseObserver) {
        System.out.println("workExperienceCreate");

        try {
            WorkExperienceController workExperienceController = new WorkExperienceController();
            WorkExperiences workExperience = workExperienceController.workExperienceRegister(request);
            responseObserver.onNext(Converter.workExpToFullProto(workExperience));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void workExperienceDelete(ServerClient.WorkExperienceFullInfo request, StreamObserver<ServerClient.Answer> responseObserver) {
        System.out.println("workExperienceDelete");

        try {
            WorkExperienceController workExperienceController = new WorkExperienceController();
            Boolean bool = workExperienceController.workExperienceDelete(request);
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
