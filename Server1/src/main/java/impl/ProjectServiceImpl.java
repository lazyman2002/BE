package impl;

import com.google.protobuf.BoolValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.ProjectController;
import org.model.Projects;
import proto.ProjectServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class ProjectServiceImpl extends ProjectServiceGrpc.ProjectServiceImplBase {
    @Override
    public void projectCreate(ServerClient.ProjectFullInfo request, StreamObserver<ServerClient.ProjectFullInfo> responseObserver) {
        System.out.println("projectCreate");

        try {
            ProjectController projectController = new ProjectController();
            Projects project = projectController.projectRegister(request);
            responseObserver.onNext(Converter.projectToProto(project));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void projectRead(ServerClient.ProjectFullInfo request, StreamObserver<ServerClient.ProjectFullInfo> responseObserver) {
        System.out.println("projectRead");

        try {
            ProjectController projectController = new ProjectController();
            Projects project = projectController.projectRead(request);
            responseObserver.onNext(Converter.projectToProto(project));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void projectUpdateInfo(ServerClient.ProjectFullInfo request, StreamObserver<ServerClient.ProjectFullInfo> responseObserver) {
        System.out.println("projectUpdateInfo");

        try {
            ProjectController projectController = new ProjectController();
            Projects project = projectController.projectUpdate(request);
            responseObserver.onNext(Converter.projectToProto(project));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void projectDelete(ServerClient.ProjectFullInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("projectDelete");

        try {
            ProjectController projectController = new ProjectController();
            Boolean success = projectController.projectDelete(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(success).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void projectListRead(ServerClient.CVFullInfo request, StreamObserver<ServerClient.ProjectFullInfo> responseObserver) {
        System.out.println("projectListRead");

        ProjectController projectController = new ProjectController();
        try {
            ArrayList<Projects> projects = projectController.projectList(request);
            for (Projects project : projects) {
                ServerClient.ProjectFullInfo projectFullInfo = Converter.projectToProto(project);
                responseObserver.onNext(projectFullInfo);
            }
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
