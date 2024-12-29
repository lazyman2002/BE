package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobRequestServiceGrpc {

  private JobRequestServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.JobRequestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestRegister",
      requestType = proto.ServerClient.JobRequestFullInfo.class,
      responseType = proto.ServerClient.JobRequestFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestRegisterMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo, proto.ServerClient.JobRequestFullInfo> getJobRequestRegisterMethod;
    if ((getJobRequestRegisterMethod = JobRequestServiceGrpc.getJobRequestRegisterMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestRegisterMethod = JobRequestServiceGrpc.getJobRequestRegisterMethod) == null) {
          JobRequestServiceGrpc.getJobRequestRegisterMethod = getJobRequestRegisterMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestFullInfo, proto.ServerClient.JobRequestFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestRegister"))
              .build();
        }
      }
    }
    return getJobRequestRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestRead",
      requestType = proto.ServerClient.JobRequestMetaInfo.class,
      responseType = proto.ServerClient.JobRequestFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo, proto.ServerClient.JobRequestFullInfo> getJobRequestReadMethod;
    if ((getJobRequestReadMethod = JobRequestServiceGrpc.getJobRequestReadMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestReadMethod = JobRequestServiceGrpc.getJobRequestReadMethod) == null) {
          JobRequestServiceGrpc.getJobRequestReadMethod = getJobRequestReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestMetaInfo, proto.ServerClient.JobRequestFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestRead"))
              .build();
        }
      }
    }
    return getJobRequestReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.JobRequestFullInfo> getJobRequestListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.JobRequestFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.JobRequestFullInfo> getJobRequestListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.JobRequestFullInfo> getJobRequestListReadMethod;
    if ((getJobRequestListReadMethod = JobRequestServiceGrpc.getJobRequestListReadMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestListReadMethod = JobRequestServiceGrpc.getJobRequestListReadMethod) == null) {
          JobRequestServiceGrpc.getJobRequestListReadMethod = getJobRequestListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.JobRequestFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestListRead"))
              .build();
        }
      }
    }
    return getJobRequestListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestUpdateInfo",
      requestType = proto.ServerClient.JobRequestFullInfo.class,
      responseType = proto.ServerClient.JobRequestFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      proto.ServerClient.JobRequestFullInfo> getJobRequestUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo, proto.ServerClient.JobRequestFullInfo> getJobRequestUpdateInfoMethod;
    if ((getJobRequestUpdateInfoMethod = JobRequestServiceGrpc.getJobRequestUpdateInfoMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestUpdateInfoMethod = JobRequestServiceGrpc.getJobRequestUpdateInfoMethod) == null) {
          JobRequestServiceGrpc.getJobRequestUpdateInfoMethod = getJobRequestUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestFullInfo, proto.ServerClient.JobRequestFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestUpdateInfo"))
              .build();
        }
      }
    }
    return getJobRequestUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo,
      com.google.protobuf.BoolValue> getJobRequestDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestDelete",
      requestType = proto.ServerClient.JobRequestMetaInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo,
      com.google.protobuf.BoolValue> getJobRequestDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestMetaInfo, com.google.protobuf.BoolValue> getJobRequestDeleteMethod;
    if ((getJobRequestDeleteMethod = JobRequestServiceGrpc.getJobRequestDeleteMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestDeleteMethod = JobRequestServiceGrpc.getJobRequestDeleteMethod) == null) {
          JobRequestServiceGrpc.getJobRequestDeleteMethod = getJobRequestDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestMetaInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestDelete"))
              .build();
        }
      }
    }
    return getJobRequestDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getJobRequestApplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestApply",
      requestType = proto.ServerClient.JobRequestFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getJobRequestApplyMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue> getJobRequestApplyMethod;
    if ((getJobRequestApplyMethod = JobRequestServiceGrpc.getJobRequestApplyMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestApplyMethod = JobRequestServiceGrpc.getJobRequestApplyMethod) == null) {
          JobRequestServiceGrpc.getJobRequestApplyMethod = getJobRequestApplyMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestApply"))
              .build();
        }
      }
    }
    return getJobRequestApplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getJobRequestWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JobRequestWithdraw",
      requestType = proto.ServerClient.JobRequestFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getJobRequestWithdrawMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue> getJobRequestWithdrawMethod;
    if ((getJobRequestWithdrawMethod = JobRequestServiceGrpc.getJobRequestWithdrawMethod) == null) {
      synchronized (JobRequestServiceGrpc.class) {
        if ((getJobRequestWithdrawMethod = JobRequestServiceGrpc.getJobRequestWithdrawMethod) == null) {
          JobRequestServiceGrpc.getJobRequestWithdrawMethod = getJobRequestWithdrawMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobRequestWithdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new JobRequestServiceMethodDescriptorSupplier("JobRequestWithdraw"))
              .build();
        }
      }
    }
    return getJobRequestWithdrawMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JobRequestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceStub>() {
        @java.lang.Override
        public JobRequestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobRequestServiceStub(channel, callOptions);
        }
      };
    return JobRequestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobRequestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceBlockingStub>() {
        @java.lang.Override
        public JobRequestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobRequestServiceBlockingStub(channel, callOptions);
        }
      };
    return JobRequestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobRequestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobRequestServiceFutureStub>() {
        @java.lang.Override
        public JobRequestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobRequestServiceFutureStub(channel, callOptions);
        }
      };
    return JobRequestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class JobRequestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void jobRequestRegister(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestRegisterMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestRead(proto.ServerClient.JobRequestMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestReadMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestListReadMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestUpdateInfo(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestDelete(proto.ServerClient.JobRequestMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestDeleteMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestApply(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestApplyMethod(), responseObserver);
    }

    /**
     */
    public void jobRequestWithdraw(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobRequestWithdrawMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getJobRequestRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestFullInfo,
                proto.ServerClient.JobRequestFullInfo>(
                  this, METHODID_JOB_REQUEST_REGISTER)))
          .addMethod(
            getJobRequestReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestMetaInfo,
                proto.ServerClient.JobRequestFullInfo>(
                  this, METHODID_JOB_REQUEST_READ)))
          .addMethod(
            getJobRequestListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.JobRequestFullInfo>(
                  this, METHODID_JOB_REQUEST_LIST_READ)))
          .addMethod(
            getJobRequestUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestFullInfo,
                proto.ServerClient.JobRequestFullInfo>(
                  this, METHODID_JOB_REQUEST_UPDATE_INFO)))
          .addMethod(
            getJobRequestDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestMetaInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_JOB_REQUEST_DELETE)))
          .addMethod(
            getJobRequestApplyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_JOB_REQUEST_APPLY)))
          .addMethod(
            getJobRequestWithdrawMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_JOB_REQUEST_WITHDRAW)))
          .build();
    }
  }

  /**
   */
  public static final class JobRequestServiceStub extends io.grpc.stub.AbstractAsyncStub<JobRequestServiceStub> {
    private JobRequestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobRequestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobRequestServiceStub(channel, callOptions);
    }

    /**
     */
    public void jobRequestRegister(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestRead(proto.ServerClient.JobRequestMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getJobRequestListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestUpdateInfo(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestDelete(proto.ServerClient.JobRequestMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestApply(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestApplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void jobRequestWithdraw(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJobRequestWithdrawMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class JobRequestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<JobRequestServiceBlockingStub> {
    private JobRequestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobRequestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobRequestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.JobRequestFullInfo jobRequestRegister(proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.JobRequestFullInfo jobRequestRead(proto.ServerClient.JobRequestMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.JobRequestFullInfo> jobRequestListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getJobRequestListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.JobRequestFullInfo jobRequestUpdateInfo(proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue jobRequestDelete(proto.ServerClient.JobRequestMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue jobRequestApply(proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestApplyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue jobRequestWithdraw(proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJobRequestWithdrawMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class JobRequestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<JobRequestServiceFutureStub> {
    private JobRequestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobRequestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobRequestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.JobRequestFullInfo> jobRequestRegister(
        proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.JobRequestFullInfo> jobRequestRead(
        proto.ServerClient.JobRequestMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.JobRequestFullInfo> jobRequestUpdateInfo(
        proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> jobRequestDelete(
        proto.ServerClient.JobRequestMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> jobRequestApply(
        proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestApplyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> jobRequestWithdraw(
        proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJobRequestWithdrawMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOB_REQUEST_REGISTER = 0;
  private static final int METHODID_JOB_REQUEST_READ = 1;
  private static final int METHODID_JOB_REQUEST_LIST_READ = 2;
  private static final int METHODID_JOB_REQUEST_UPDATE_INFO = 3;
  private static final int METHODID_JOB_REQUEST_DELETE = 4;
  private static final int METHODID_JOB_REQUEST_APPLY = 5;
  private static final int METHODID_JOB_REQUEST_WITHDRAW = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobRequestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobRequestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOB_REQUEST_REGISTER:
          serviceImpl.jobRequestRegister((proto.ServerClient.JobRequestFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_READ:
          serviceImpl.jobRequestRead((proto.ServerClient.JobRequestMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_LIST_READ:
          serviceImpl.jobRequestListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_UPDATE_INFO:
          serviceImpl.jobRequestUpdateInfo((proto.ServerClient.JobRequestFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.JobRequestFullInfo>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_DELETE:
          serviceImpl.jobRequestDelete((proto.ServerClient.JobRequestMetaInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_APPLY:
          serviceImpl.jobRequestApply((proto.ServerClient.JobRequestFullInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_JOB_REQUEST_WITHDRAW:
          serviceImpl.jobRequestWithdraw((proto.ServerClient.JobRequestFullInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
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

  private static abstract class JobRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobRequestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JobRequestService");
    }
  }

  private static final class JobRequestServiceFileDescriptorSupplier
      extends JobRequestServiceBaseDescriptorSupplier {
    JobRequestServiceFileDescriptorSupplier() {}
  }

  private static final class JobRequestServiceMethodDescriptorSupplier
      extends JobRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobRequestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (JobRequestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JobRequestServiceFileDescriptorSupplier())
              .addMethod(getJobRequestRegisterMethod())
              .addMethod(getJobRequestReadMethod())
              .addMethod(getJobRequestListReadMethod())
              .addMethod(getJobRequestUpdateInfoMethod())
              .addMethod(getJobRequestDeleteMethod())
              .addMethod(getJobRequestApplyMethod())
              .addMethod(getJobRequestWithdrawMethod())
              .build();
        }
      }
    }
    return result;
  }
}
