package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SearchServiceGrpc {

  private SearchServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.SearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestRestrict,
      proto.ServerClient.JobRequestFullInfo> getCandidateJobRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Candidate_JobRequest",
      requestType = proto.ServerClient.JobRequestRestrict.class,
      responseType = proto.ServerClient.JobRequestFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestRestrict,
      proto.ServerClient.JobRequestFullInfo> getCandidateJobRequestMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestRestrict, proto.ServerClient.JobRequestFullInfo> getCandidateJobRequestMethod;
    if ((getCandidateJobRequestMethod = SearchServiceGrpc.getCandidateJobRequestMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getCandidateJobRequestMethod = SearchServiceGrpc.getCandidateJobRequestMethod) == null) {
          SearchServiceGrpc.getCandidateJobRequestMethod = getCandidateJobRequestMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestRestrict, proto.ServerClient.JobRequestFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Candidate_JobRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestRestrict.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("Candidate_JobRequest"))
              .build();
        }
      }
    }
    return getCandidateJobRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CompanyFullInfo> getRecruiterCompanyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recruiter_Company",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = proto.ServerClient.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CompanyFullInfo> getRecruiterCompanyMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, proto.ServerClient.CompanyFullInfo> getRecruiterCompanyMethod;
    if ((getRecruiterCompanyMethod = SearchServiceGrpc.getRecruiterCompanyMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getRecruiterCompanyMethod = SearchServiceGrpc.getRecruiterCompanyMethod) == null) {
          SearchServiceGrpc.getRecruiterCompanyMethod = getRecruiterCompanyMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, proto.ServerClient.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recruiter_Company"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("Recruiter_Company"))
              .build();
        }
      }
    }
    return getRecruiterCompanyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CVFullInfo> getCVUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CV_User",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = proto.ServerClient.CVFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CVFullInfo> getCVUserMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, proto.ServerClient.CVFullInfo> getCVUserMethod;
    if ((getCVUserMethod = SearchServiceGrpc.getCVUserMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getCVUserMethod = SearchServiceGrpc.getCVUserMethod) == null) {
          SearchServiceGrpc.getCVUserMethod = getCVUserMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, proto.ServerClient.CVFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CV_User"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("CV_User"))
              .build();
        }
      }
    }
    return getCVUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub>() {
        @java.lang.Override
        public SearchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceStub(channel, callOptions);
        }
      };
    return SearchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub>() {
        @java.lang.Override
        public SearchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceBlockingStub(channel, callOptions);
        }
      };
    return SearchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub>() {
        @java.lang.Override
        public SearchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceFutureStub(channel, callOptions);
        }
      };
    return SearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SearchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void candidateJobRequest(proto.ServerClient.JobRequestRestrict request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCandidateJobRequestMethod(), responseObserver);
    }

    /**
     */
    public void recruiterCompany(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecruiterCompanyMethod(), responseObserver);
    }

    /**
     */
    public void cVUser(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCandidateJobRequestMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestRestrict,
                proto.ServerClient.JobRequestFullInfo>(
                  this, METHODID_CANDIDATE_JOB_REQUEST)))
          .addMethod(
            getRecruiterCompanyMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                proto.ServerClient.CompanyFullInfo>(
                  this, METHODID_RECRUITER_COMPANY)))
          .addMethod(
            getCVUserMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                proto.ServerClient.CVFullInfo>(
                  this, METHODID_CV_USER)))
          .build();
    }
  }

  /**
   */
  public static final class SearchServiceStub extends io.grpc.stub.AbstractAsyncStub<SearchServiceStub> {
    private SearchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceStub(channel, callOptions);
    }

    /**
     */
    public void candidateJobRequest(proto.ServerClient.JobRequestRestrict request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCandidateJobRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recruiterCompany(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRecruiterCompanyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cVUser(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCVUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SearchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SearchServiceBlockingStub> {
    private SearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.JobRequestFullInfo> candidateJobRequest(
        proto.ServerClient.JobRequestRestrict request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCandidateJobRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CompanyFullInfo> recruiterCompany(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRecruiterCompanyMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CVFullInfo> cVUser(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCVUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SearchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SearchServiceFutureStub> {
    private SearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CANDIDATE_JOB_REQUEST = 0;
  private static final int METHODID_RECRUITER_COMPANY = 1;
  private static final int METHODID_CV_USER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANDIDATE_JOB_REQUEST:
          serviceImpl.candidateJobRequest((proto.ServerClient.JobRequestRestrict) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo>) responseObserver);
          break;
        case METHODID_RECRUITER_COMPANY:
          serviceImpl.recruiterCompany((proto.ServerClient.UserMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_CV_USER:
          serviceImpl.cVUser((proto.ServerClient.UserMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchService");
    }
  }

  private static final class SearchServiceFileDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier {
    SearchServiceFileDescriptorSupplier() {}
  }

  private static final class SearchServiceMethodDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SearchServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchServiceFileDescriptorSupplier())
              .addMethod(getCandidateJobRequestMethod())
              .addMethod(getRecruiterCompanyMethod())
              .addMethod(getCVUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
