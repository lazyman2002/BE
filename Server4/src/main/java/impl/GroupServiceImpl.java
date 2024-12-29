package impl;

import com.google.protobuf.BoolValue;
import hadoop.HadoopService;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.GroupController;
import org.model.Groups;
import proto.GroupServiceGrpc;
import proto.ServerChat;

import java.util.ArrayList;

public class GroupServiceImpl extends GroupServiceGrpc.GroupServiceImplBase {
    @Override
    public void groupCreate(ServerChat.GroupMetaInfo request, StreamObserver<ServerChat.GroupMetaInfo> responseObserver) {
        System.out.println("groupCreate");
        try {
            GroupController groupController = new GroupController();
            Groups groups = groupController.groupRegister(request);
            responseObserver.onNext(Converter.groupToProto(groups));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }


    }

    @Override
    public void groupListRead(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupMetaInfo> responseObserver) {
        System.out.println("groupListRead");

        GroupController skillController = new GroupController();
        try {
            ArrayList<Groups> groups = skillController.groupList(request);
            HadoopService hadoopService =  new HadoopService();
            groups = hadoopService.sortBySendTime(groups);
            for (Groups group : groups) {
                ServerChat.GroupMetaInfo groupMetaInfo = Converter.groupToProto(group);
                responseObserver.onNext(groupMetaInfo);
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
    public void groupRead(ServerChat.GroupMetaInfo request, StreamObserver<ServerChat.GroupMetaInfo> responseObserver) {
        System.out.println("groupRead");

        try {
            GroupController groupController = new GroupController();
            Groups groups = groupController.groupRead(request);
            responseObserver.onNext(Converter.groupToProto(groups));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void groupUpdateInfo(ServerChat.GroupMetaInfo request, StreamObserver<ServerChat.GroupMetaInfo> responseObserver) {
        System.out.println("groupUpdateInfo");

        try {
            GroupController groupController = new GroupController();
            Groups groups = groupController.groupUpdate(request);
            responseObserver.onNext(Converter.groupToProto(groups));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void groupDelete(ServerChat.GroupMetaInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("groupDelete");

        try {
            GroupController skillController = new GroupController();
            Boolean bool = skillController.groupDelete(request);
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
    public void groupDeleteMember(ServerChat.GroupMember request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("groupDeleteMember");

        try {
            GroupController groupController = new GroupController();
            Boolean bool = groupController.memberDelete(request);
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
    public void groupAppendMember(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupMetaInfo> responseObserver) {
        System.out.println("groupAppendMember");

        try {
            GroupController groupController = new GroupController();
            Groups groups = groupController.groupAppendMember(request);
            responseObserver.onNext(Converter.groupToProto(groups));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
