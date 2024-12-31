package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.GroupController;
import org.controller.ScheduleController;
import org.model.Groups;
import org.model.Schedules;
import proto.ScheduleServiceGrpc;
import proto.ServerChat;

import java.util.ArrayList;

public class ScheduleServiceImpl extends ScheduleServiceGrpc.ScheduleServiceImplBase {
    @Override
    public void scheduleCreate(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        System.out.println("scheduleCreate");

        try {
            ScheduleController scheduleController = new ScheduleController();
            Schedules schedules = scheduleController.scheduleCreate(request);
            responseObserver.onNext(Converter.scheduleToProto(schedules));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void scheduleListRead(ServerChat.GroupMetaInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        System.out.println("scheduleListRead");

        ScheduleController scheduleController = new ScheduleController();
        try {
            ArrayList<Schedules> schedules = scheduleController.scheduleList(request);
            for (Schedules schedule : schedules) {
                ServerChat.ScheduleFullInfo scheduleFullInfo = Converter.scheduleToProto(schedule);
                responseObserver.onNext(scheduleFullInfo);
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
    public void scheduleRead(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        System.out.println("scheduleRead");

        try {
            ScheduleController scheduleController = new ScheduleController();
            Schedules schedule = scheduleController.scheduleRead(request);
            responseObserver.onNext(Converter.scheduleToProto(schedule));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void scheduleUpdate(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        System.out.println("scheduleUpdate");

        try {
            ScheduleController scheduleController = new ScheduleController();
            Schedules schedule = scheduleController.scheduleUpdate(request);
            responseObserver.onNext(Converter.scheduleToProto(schedule));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void scheduleDelete(ServerChat.ScheduleFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("scheduleDelete");

        try {
            ScheduleController scheduleController = new ScheduleController();
            Boolean bool = scheduleController.scheduleDelete(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(bool).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void scheduleAppendInterviewer(ServerChat.ScheduleFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("scheduleAppendInterviewer");

        try {
            ScheduleController scheduleController = new ScheduleController();
            scheduleController.scheduleAppendInterviewer(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void scheduleDeleteInterviewer(ServerChat.ScheduleFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("scheduleDeleteInterviewer");

        try {
            ScheduleController scheduleController = new ScheduleController();
            scheduleController.scheduleDeleteInterviewer(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            // Handle any exceptions during deletion
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
