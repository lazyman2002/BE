package impl;

import com.google.protobuf.BoolValue;
import io.grpc.stub.StreamObserver;
import proto.ScheduleServiceGrpc;
import proto.ServerChat;

public class ScheduleServiceImpl extends ScheduleServiceGrpc.ScheduleServiceImplBase {
    @Override
    public void scheduleCreate(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        super.scheduleCreate(request, responseObserver);
    }

    @Override
    public void scheduleListRead(ServerChat.GroupMetaInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        super.scheduleListRead(request, responseObserver);
    }

    @Override
    public void scheduleRead(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        super.scheduleRead(request, responseObserver);
    }

    @Override
    public void scheduleUpdate(ServerChat.ScheduleFullInfo request, StreamObserver<ServerChat.ScheduleFullInfo> responseObserver) {
        super.scheduleUpdate(request, responseObserver);
    }

    @Override
    public void scheduleDelete(ServerChat.ScheduleFullInfo request, StreamObserver<BoolValue> responseObserver) {
        super.scheduleDelete(request, responseObserver);
    }
}
