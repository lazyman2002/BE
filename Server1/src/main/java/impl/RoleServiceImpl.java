package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.RoleController;
import org.model.Roles;
import proto.RoleServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class RoleServiceImpl extends RoleServiceGrpc.RoleServiceImplBase {
    @Override
    public void roleListRead(ServerClient.CompanyMetaInfo request, StreamObserver<ServerClient.RoleFullInfo> responseObserver) {
        System.out.println("roleListRead");

        RoleController roleController = new RoleController();
        try {
            ArrayList<Roles> roles = roleController.roleList(request);
            System.out.println(roles);
            for (Roles role: roles){
                ServerClient.RoleFullInfo roleFullInfo = Converter.rolesToProto(role);
                responseObserver.onNext(roleFullInfo);
            }
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
    public void roleReadInfo(ServerClient.RoleFullInfo request, StreamObserver<ServerClient.RoleFullInfo> responseObserver) {
        System.out.println("roleReadInfo");

        try {
            RoleController roleController = new RoleController();
            Roles roles = roleController.roleRead(request);
            responseObserver.onNext(Converter.rolesToProto(roles));
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
    public void roleUpdateInfo(ServerClient.RoleFullInfo request, StreamObserver<ServerClient.RoleFullInfo> responseObserver) {
        System.out.println("roleRegister");

        try {
            RoleController roleController = new RoleController();
            Roles roles = roleController.rolesUpdate(request);
            responseObserver.onNext(Converter.rolesToProto(roles));
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
    public void roleRegister(ServerClient.RoleFullInfo request, StreamObserver<ServerClient.RoleFullInfo> responseObserver) {
        System.out.println("roleRegister");

        try {
            RoleController roleController = new RoleController();
            Roles roles = roleController.roleRegister(request);
            responseObserver.onNext(Converter.rolesToProto(roles));
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void roleDeleteInfo(ServerClient.RoleFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("roleDeleteInfo");

        try {
            RoleController roleController = new RoleController();
            Boolean bool = roleController.roleDelete(request);
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
