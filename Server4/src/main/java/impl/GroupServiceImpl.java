package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.GroupController;
import org.model.GroupMembers;
import org.model.Groups;
import proto.GroupServiceGrpc;
import proto.ServerChat;

import java.time.Instant;
import java.util.ArrayList;

public class GroupServiceImpl extends GroupServiceGrpc.GroupServiceImplBase {
    @Override
    public void groupCreate(ServerChat.GroupInfo request, StreamObserver<ServerChat.GroupInfo> responseObserver) {
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
    public void groupListRead(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupInfo> responseObserver) {
        System.out.println("groupListRead");

        GroupController skillController = new GroupController();
        try {
            ArrayList<Groups> groups = skillController.groupList(request);
//            HadoopService hadoopService =  new HadoopService();
//            groups = hadoopService.sortBySendTime(groups);

            for (Groups group : groups) {
                ServerChat.GroupInfo groupMetaInfo = Converter.groupToProto(group);
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
    public void groupRead(ServerChat.GroupInfo request, StreamObserver<ServerChat.GroupInfo> responseObserver) {
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
    public void groupUpdateInfo(ServerChat.GroupInfo request, StreamObserver<ServerChat.GroupInfo> responseObserver) {
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
    public void groupDelete(ServerChat.GroupInfo request, StreamObserver<BoolValue> responseObserver) {
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
    public void groupAppendMember(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupInfo> responseObserver) {
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

    @Override
    public void groupMemberRead(ServerChat.GroupInfo request, StreamObserver<ServerChat.GroupMember> responseObserver) {
        System.out.println("groupMemberRead");

        try {
            GroupController groupController = new GroupController();
            ArrayList<ServerChat.GroupMember> groupMembers = groupController.groupMemberRead(request);
            for (ServerChat.GroupMember groupMember: groupMembers){
                responseObserver.onNext(groupMember);
            }
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void groupMemberUpdate(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupMember> responseObserver) {
        System.out.println("groupMemberUpdate");

        try {
            GroupController groupController = new GroupController();
            ServerChat.GroupMember groupMembers = groupController.groupMemberUpdate(request);
            responseObserver.onNext(groupMembers);
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void groupMemberInterview(ServerChat.GroupMember request, StreamObserver<ServerChat.GroupMember> responseObserver) {
        System.out.println("groupMemberInterview");

        try {
            GroupController groupController = new GroupController();
            ArrayList<GroupMembers> groupMembers = groupController.groupMemberInterview(request);
            java.sql.Timestamp now = java.sql.Timestamp.from(Instant.now());
            java.sql.Timestamp closestTimestamp = null;
            GroupMembers closest = new GroupMembers();

            for (GroupMembers groupMember : groupMembers) {
                if (groupMember.getSchedule() != null && groupMember.getInterview() != null) {
                    long dateMillis = groupMember.getSchedule().getTime();
                    long timeMillis = groupMember.getInterview().getTime() % (24 * 60 * 60 * 1000);
                    java.sql.Timestamp interviewTimestamp = new java.sql.Timestamp(dateMillis + timeMillis);

//                    if (interviewTimestamp.after(now)) {
                        if (closestTimestamp == null || interviewTimestamp.before(closestTimestamp)
                        ) {
                            closestTimestamp = interviewTimestamp;
                            closest = groupMember;
                        }
//                    }
                }
            }
            System.out.println(closest);
            responseObserver.onNext(Converter.groupMemberToProto(closest));
            responseObserver.onCompleted();
        }
         catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
