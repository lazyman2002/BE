package impl;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.*;
import org.model.Candidates;
import org.model.Recruiters;
import org.model.Users;
import proto.ServerClient;
import proto.UserServiceGrpc;

import java.util.ArrayList;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void candidateCreate(ServerClient.CandidateFullInfo request, StreamObserver<ServerClient.CandidateFullInfo> responseObserver) {
        System.out.println("candidateCreate");
        try {
            CandidateController candidateController = new CandidateController();
            Candidates candidates = candidateController.candidateCreate(request);
            ServerClient.CandidateFullInfo candidateFullInfo = Converter.candidatesToProto(candidates);
            responseObserver.onNext(candidateFullInfo);
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
    public void recruiterCreate(ServerClient.RecruiterFullInfo request, StreamObserver<ServerClient.RecruiterFullInfo> responseObserver) {
        System.out.println("recruiterCreate");
        try {
            System.out.println(request);
            RecruiterController recruiterController = new RecruiterController();
            Recruiters recruiters = recruiterController.recruiterCreate(request);
            ServerClient.RecruiterFullInfo recruiterFullInfo = Converter.recruiterToProto(recruiters);
            responseObserver.onNext(recruiterFullInfo);
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
    public void userRead(ServerClient.UserFullInfo request, StreamObserver<ServerClient.UserFullInfo> responseObserver) {
        System.out.println("userRead");
        try {
            UserController userController = new UserController();
            Users users = userController.userRead(request);
            ServerClient.UserFullInfo userFullInfo = Converter.usersToProto(users);
            responseObserver.onNext(userFullInfo);
            responseObserver.onCompleted();
        }
        catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void candidateRead(ServerClient.UserFullInfo request, StreamObserver<ServerClient.CandidateFullInfo> responseObserver) {
        System.out.println("candidateRead");
        try {
            CandidateController candidateController = new CandidateController();
            Candidates candidates = candidateController.candidateRead(request);
            ServerClient.CandidateFullInfo candidateFullInfo = Converter.candidatesToProto(candidates);
            responseObserver.onNext(candidateFullInfo);
            responseObserver.onCompleted();
        }
        catch (Exception exception){
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(exception.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void recruiterRead(ServerClient.UserFullInfo request, StreamObserver<ServerClient.RecruiterFullInfo> responseObserver) {
        System.out.println("recruiterRead");
        try {
            RecruiterController recruiterController = new RecruiterController();
            Recruiters recruiters = recruiterController.recruiterRead(request);
            ServerClient.RecruiterFullInfo recruiterFullInfo = Converter.recruiterToProto(recruiters);
            responseObserver.onNext(recruiterFullInfo);
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException exception = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(exception);
        }
    }

    @Override
    public void userUpdate(ServerClient.UserFullInfo request, StreamObserver<ServerClient.UserFullInfo> responseObserver) {
        System.out.println("userUpdate");
        try {
            UserController userController = new UserController();
            Users users = userController.userUpdate(request);
            ServerClient.UserFullInfo userFullInfo = Converter.usersToProto(users);
            responseObserver.onNext(userFullInfo);
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException exception = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(exception);
        }
    }

    @Override
    public void candidateUpdate(ServerClient.CandidateFullInfo request, StreamObserver<ServerClient.CandidateFullInfo> responseObserver) {
        System.out.println("candidateUpdate");
        try {
            CandidateController candidateController = new CandidateController();
            Candidates candidates = candidateController.candidateUpdate(request);
            ServerClient.CandidateFullInfo candidateFullInfo = Converter.candidatesToProto(candidates);
            responseObserver.onNext(candidateFullInfo);
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException exception = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(exception);
        }
    }

    @Override
    public void recruiterUpdate(ServerClient.RecruiterFullInfo request, StreamObserver<ServerClient.RecruiterFullInfo> responseObserver) {
        System.out.println("recruiterUpdate");
        try{
            RecruiterController recruiterController = new RecruiterController();
            Recruiters recruiters = recruiterController.recruiterUpdate(request);
            ServerClient.RecruiterFullInfo recruiterFullInfo = Converter.recruiterToProto(recruiters);
            responseObserver.onNext(recruiterFullInfo);
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException exception = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(exception);
        }
    }

    @Override
    public void userDelete(ServerClient.UserFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("userDelete");
        try {
            UserController userController = new UserController();
            Boolean ans = userController.userDelete(request);
            if(ans){
                responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
            }
            else {
                responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
            }
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException exception = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(exception);
        }
    }

    @Override
    public void userListRead(Empty request, StreamObserver<ServerClient.UserFullInfo> responseObserver) {
        System.out.println("userListRead");
        try {
            UserController userController = new UserController();
            ArrayList<Users> usersArrayList = userController.userList();
            for(Users users : usersArrayList){
                ServerClient.UserFullInfo userFullInfo = Converter.usersToProto(users);
                responseObserver.onNext(userFullInfo);
            }
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void recruiterListRead(Empty request, StreamObserver<ServerClient.RecruiterFullInfo> responseObserver) {
        System.out.println("recruiterListRead");
        try {
            RecruiterController recruiterController = new RecruiterController();
            ArrayList<Recruiters>   recruitersArrayList = recruiterController.recruiterList();
            for (Recruiters recruiters: recruitersArrayList){
                ServerClient.RecruiterFullInfo recruiterFullInfo = Converter.recruiterToProto(recruiters);
                responseObserver.onNext(recruiterFullInfo);
            }
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void candidateListRead(Empty request, StreamObserver<ServerClient.CandidateFullInfo> responseObserver) {
        System.out.println("candidateListRead");
        try {
            CandidateController candidateController = new CandidateController();
            ArrayList<Candidates> candidateArrayList = candidateController.candidateList();
            for (Candidates candidates : candidateArrayList){
                ServerClient.CandidateFullInfo candidateFullInfo = Converter.candidatesToProto(candidates);
                responseObserver.onNext(candidateFullInfo);
            }
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
