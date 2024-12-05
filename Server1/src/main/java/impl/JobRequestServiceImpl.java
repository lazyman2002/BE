package impl;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.ApplyController;
import org.controller.Converter;
import org.controller.JobController;
import org.model.JobRequests;
import proto.JobRequestServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class JobRequestServiceImpl extends JobRequestServiceGrpc.JobRequestServiceImplBase {
    @Override
    public void jobRequestRead(ServerClient.JobRequestMetaInfo request, StreamObserver<ServerClient.JobRequestFullInfo> responseObserver) {
        System.out.println("jobRequestReadInfo");
        try {
            JobController jobController = new JobController();
            JobRequests jobRequest = jobController.jobRequestRead(request);
            responseObserver.onNext(Converter.jobRequestsToFullProto(jobRequest));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.INTERNAL
                    .withDescription("An error occurred while processing the job request: " + e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void jobRequestRegister(ServerClient.JobRequestFullInfo request, StreamObserver<ServerClient.JobRequestFullInfo> responseObserver) {
        System.out.println("jobRegister");

        try {
            JobController jobRequestController = new JobController();
            JobRequests jobRequest = jobRequestController.jobRequestRegister(request);
            responseObserver.onNext(Converter.jobRequestsToFullProto(jobRequest));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void jobRequestUpdateInfo(ServerClient.JobRequestFullInfo request, StreamObserver<ServerClient.JobRequestFullInfo> responseObserver) {
        System.out.println("jobRequestUpdateInfo");

        try {
            JobController jobController = new JobController();
            JobRequests jobRequest = jobController.jobRequestsUpdate(request);
            responseObserver.onNext(Converter.jobRequestsToFullProto(jobRequest));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void jobRequestDelete(ServerClient.JobRequestMetaInfo request, StreamObserver<ServerClient.Answer> responseObserver) {
        System.out.println("jobDeleteInfo");

        try {
            JobController jobController = new JobController();
            Boolean success = jobController.jobDelete(request);
            responseObserver.onNext(ServerClient.Answer.newBuilder().setAnsBool(success).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void jobRequestListRead(Empty request, StreamObserver<ServerClient.JobRequestFullInfo> responseObserver) {
        System.out.println("jobRequestListRead");

        JobController jobController = new JobController();
        try {
            ArrayList<JobRequests> jobRequests = jobController.jobRequestsList();
            System.out.println(jobRequests);
            for (JobRequests job: jobRequests){
                ServerClient.JobRequestFullInfo jobRequestFullInfo = Converter.jobRequestsToFullProto(job);
                responseObserver.onNext(jobRequestFullInfo);
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
    public void jobRequestApply(ServerClient.JobRequestFullInfo request, StreamObserver<ServerClient.Answer> responseObserver) {
        System.out.println("jobRequestApply");
        try {
            ApplyController applyController = new ApplyController();
            Boolean bool = applyController.CVApply(request);
            responseObserver.onNext(ServerClient.Answer.newBuilder().setAnsBool(bool).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}