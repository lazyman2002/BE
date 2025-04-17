package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.AwardController;
import org.controller.Converter;
import org.model.Awards;
import proto.AwardServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class AwardServiceImpl extends AwardServiceGrpc.AwardServiceImplBase {

    @Override
    public void awardListRead(ServerClient.CVFullInfo request, StreamObserver<ServerClient.AwardFullInfo> responseObserver) {
        System.out.println("awardListRead");

        AwardController awardController = new AwardController();
        try {
            ArrayList<Awards> awards = awardController.awardList(request);
            System.out.println(awards);
            for (Awards award : awards) {
                ServerClient.AwardFullInfo awardFullInfo = Converter.awardToFullProto(award);
                responseObserver.onNext(awardFullInfo);
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
    public void awardRead(ServerClient.AwardFullInfo request, StreamObserver<ServerClient.AwardFullInfo> responseObserver) {
        System.out.println("awardRead");

        try {
            AwardController awardController = new AwardController();
            Awards award = awardController.awardRead(request);
            responseObserver.onNext(Converter.awardToFullProto(award));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void awardUpdateInfo(ServerClient.AwardFullInfo request, StreamObserver<ServerClient.AwardFullInfo> responseObserver) {
        System.out.println("awardUpdateInfo");

        try {
            AwardController awardController = new AwardController();
            Awards award = awardController.awardUpdate(request);
            responseObserver.onNext(Converter.awardToFullProto(award));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void awardCreate(ServerClient.AwardFullInfo request, StreamObserver<ServerClient.AwardFullInfo> responseObserver) {
        System.out.println("awardCreate");

        try {
            AwardController awardController = new AwardController();
            Awards award = awardController.awardRegister(request);
            responseObserver.onNext(Converter.awardToFullProto(award));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void awardDelete(ServerClient.AwardFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("awardDelete");

        try {
            AwardController awardController = new AwardController();
            Boolean bool = awardController.awardDelete(request);
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
