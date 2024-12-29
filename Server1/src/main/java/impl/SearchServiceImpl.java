package impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.JobController;
import org.model.JobRequests;
import proto.SearchServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class SearchServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {
    @Override
    public void candidateJobRequest(ServerClient.JobRequestRestrict request, StreamObserver<ServerClient.JobRequestFullInfo> responseObserver) {
        System.out.println("candidateJobRequest");

        JobController jobController = new JobController();
        try {
            ArrayList<JobRequests> JBS = jobController.searchJob(request);
            for (JobRequests job : JBS){
                ServerClient.JobRequestFullInfo jobRequestFullInfo = Converter.jobRequestsToFullProto(job);
                responseObserver.onNext(jobRequestFullInfo);
            }
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
