package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.SkillController;
import org.model.Skills;
import proto.ServerClient;
import proto.SkillServiceGrpc;

import java.util.ArrayList;

public class SkillServiceImpl extends SkillServiceGrpc.SkillServiceImplBase {
    @Override
    public void skillListRead(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.SkillFullInfo> responseObserver) {
        System.out.println("skillListRead");

        SkillController skillController = new SkillController();
        try {
            ArrayList<Skills> skills = skillController.skillList(request);
            System.out.println(skills);
            for (Skills skill : skills) {
                ServerClient.SkillFullInfo skillFullInfo = Converter.skillsToFullProto(skill);
                responseObserver.onNext(skillFullInfo);
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
    public void skillRead(ServerClient.SkillFullInfo request, StreamObserver<ServerClient.SkillFullInfo> responseObserver) {
        System.out.println("skillRead");

        try {
            SkillController skillController = new SkillController();
            Skills skill = skillController.skillRead(request);
            responseObserver.onNext(Converter.skillsToFullProto(skill));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void skillUpdateInfo(ServerClient.SkillFullInfo request, StreamObserver<ServerClient.SkillFullInfo> responseObserver) {
        System.out.println("skillUpdateInfo");

        try {
            SkillController skillController = new SkillController();
            Skills skill = skillController.skillUpdate(request);
            responseObserver.onNext(Converter.skillsToFullProto(skill));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void skillCreate(ServerClient.SkillFullInfo request, StreamObserver<ServerClient.SkillFullInfo> responseObserver) {
        System.out.println("skillCreate");

        try {
            SkillController skillController = new SkillController();
            Skills skill = skillController.skillRegister(request);
            responseObserver.onNext(Converter.skillsToFullProto(skill));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void skillDelete(ServerClient.SkillFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("skillDelete");

        try {
            SkillController skillController = new SkillController();
            Boolean bool = skillController.skillDelete(request);
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
