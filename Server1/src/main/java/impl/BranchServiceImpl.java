package impl;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.BranchController;
import org.model.Branchs;
import org.model.Locations;
import proto.BranchServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class BranchServiceImpl extends BranchServiceGrpc.BranchServiceImplBase {
    @Override
    public void branchListRead(Empty request, StreamObserver<ServerClient.BranchFullInfo> responseObserver) {
        System.out.println("branchListRead");

        BranchController BranchController = new BranchController();
        try {
            ArrayList<Branchs> locations = BranchController.branchList();
            for (Branchs branchs : locations) {
                ServerClient.BranchFullInfo locationFullInfo = Converter.branchToFullProto(branchs);
                responseObserver.onNext(locationFullInfo);
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
    public void branchRead(ServerClient.BranchFullInfo request, StreamObserver<ServerClient.BranchFullInfo> responseObserver) {
        System.out.println("branchRead");

        try {
            BranchController BranchController = new BranchController();
            Branchs location = BranchController.branchRead(request);
            responseObserver.onNext(Converter.branchToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void branchUpdateInfo(ServerClient.BranchFullInfo request, StreamObserver<ServerClient.BranchFullInfo> responseObserver) {
        System.out.println("branchUpdateInfo");

        try {
            BranchController BranchController = new BranchController();
            Branchs location = BranchController.branchUpdate(request);
            responseObserver.onNext(Converter.branchToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void branchCreate(ServerClient.BranchFullInfo request, StreamObserver<ServerClient.BranchFullInfo> responseObserver) {
        System.out.println("branchCreate");
        try {
            BranchController branchController = new BranchController();
            Branchs location = branchController.branchRegister(request);
            responseObserver.onNext(Converter.branchToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void branchDelete(ServerClient.BranchFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("branchDelete");

        try {
            BranchController BranchController = new BranchController();
            Boolean bool = BranchController.branchDelete(request);
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
