package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.PersonalityController;
import org.controller.Converter;
import org.model.Personalities;
import proto.PersonalityServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class PersonalityServiceImpl extends PersonalityServiceGrpc.PersonalityServiceImplBase {
    @Override
    public void personalityListRead(ServerClient.CVMetaInfo request, StreamObserver<ServerClient.PersonalityFullInfo> responseObserver) {
        System.out.println("personalityListRead");

        PersonalityController personalityController = new PersonalityController();
        try {
            ArrayList<Personalities> personalities = personalityController.personalityList(request);
            System.out.println(personalities);
            for (Personalities personality : personalities) {
                ServerClient.PersonalityFullInfo personalityFullInfo = Converter.personalitiesToFullProto(personality);
                responseObserver.onNext(personalityFullInfo);
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
    public void personalityRead(ServerClient.PersonalityFullInfo request, StreamObserver<ServerClient.PersonalityFullInfo> responseObserver) {
        System.out.println("personalityRead");

        try {
            PersonalityController personalityController = new PersonalityController();
            Personalities personality = personalityController.personalityRead(request);
            responseObserver.onNext(Converter.personalitiesToFullProto(personality));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void personalityUpdateInfo(ServerClient.PersonalityFullInfo request, StreamObserver<ServerClient.PersonalityFullInfo> responseObserver) {
        System.out.println("personalityUpdateInfo");

        try {
            PersonalityController personalityController = new PersonalityController();
            Personalities personality = personalityController.personalityUpdate(request);
            responseObserver.onNext(Converter.personalitiesToFullProto(personality));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void personalityCreate(ServerClient.PersonalityFullInfo request, StreamObserver<ServerClient.PersonalityFullInfo> responseObserver) {
        System.out.println("personalityCreate");

        try {
            PersonalityController personalityController = new PersonalityController();
            Personalities personality = personalityController.personalityRegister(request);
            responseObserver.onNext(Converter.personalitiesToFullProto(personality));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void personalityDelete(ServerClient.PersonalityFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("personalityDelete");

        try {
            PersonalityController personalityController = new PersonalityController();
            Boolean bool = personalityController.personalityDelete(request);
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
