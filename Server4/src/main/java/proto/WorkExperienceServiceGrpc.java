package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkExperienceServiceGrpc {

  private WorkExperienceServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.WorkExperienceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WorkExperienceCreate",
      requestType = proto.ServerClient.WorkExperienceFullInfo.class,
      responseType = proto.ServerClient.WorkExperienceFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceCreateMethod;
    if ((getWorkExperienceCreateMethod = WorkExperienceServiceGrpc.getWorkExperienceCreateMethod) == null) {
      synchronized (WorkExperienceServiceGrpc.class) {
        if ((getWorkExperienceCreateMethod = WorkExperienceServiceGrpc.getWorkExperienceCreateMethod) == null) {
          WorkExperienceServiceGrpc.getWorkExperienceCreateMethod = getWorkExperienceCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WorkExperienceCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WorkExperienceServiceMethodDescriptorSupplier("WorkExperienceCreate"))
              .build();
        }
      }
    }
    return getWorkExperienceCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WorkExperienceRead",
      requestType = proto.ServerClient.WorkExperienceFullInfo.class,
      responseType = proto.ServerClient.WorkExperienceFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceReadMethod;
    if ((getWorkExperienceReadMethod = WorkExperienceServiceGrpc.getWorkExperienceReadMethod) == null) {
      synchronized (WorkExperienceServiceGrpc.class) {
        if ((getWorkExperienceReadMethod = WorkExperienceServiceGrpc.getWorkExperienceReadMethod) == null) {
          WorkExperienceServiceGrpc.getWorkExperienceReadMethod = getWorkExperienceReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WorkExperienceRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WorkExperienceServiceMethodDescriptorSupplier("WorkExperienceRead"))
              .build();
        }
      }
    }
    return getWorkExperienceReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WorkExperienceListRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.WorkExperienceFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceListReadMethod;
    if ((getWorkExperienceListReadMethod = WorkExperienceServiceGrpc.getWorkExperienceListReadMethod) == null) {
      synchronized (WorkExperienceServiceGrpc.class) {
        if ((getWorkExperienceListReadMethod = WorkExperienceServiceGrpc.getWorkExperienceListReadMethod) == null) {
          WorkExperienceServiceGrpc.getWorkExperienceListReadMethod = getWorkExperienceListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.WorkExperienceFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WorkExperienceListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WorkExperienceServiceMethodDescriptorSupplier("WorkExperienceListRead"))
              .build();
        }
      }
    }
    return getWorkExperienceListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WorkExperienceUpdateInfo",
      requestType = proto.ServerClient.WorkExperienceFullInfo.class,
      responseType = proto.ServerClient.WorkExperienceFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo> getWorkExperienceUpdateInfoMethod;
    if ((getWorkExperienceUpdateInfoMethod = WorkExperienceServiceGrpc.getWorkExperienceUpdateInfoMethod) == null) {
      synchronized (WorkExperienceServiceGrpc.class) {
        if ((getWorkExperienceUpdateInfoMethod = WorkExperienceServiceGrpc.getWorkExperienceUpdateInfoMethod) == null) {
          WorkExperienceServiceGrpc.getWorkExperienceUpdateInfoMethod = getWorkExperienceUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WorkExperienceFullInfo, proto.ServerClient.WorkExperienceFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WorkExperienceUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WorkExperienceServiceMethodDescriptorSupplier("WorkExperienceUpdateInfo"))
              .build();
        }
      }
    }
    return getWorkExperienceUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      com.google.protobuf.BoolValue> getWorkExperienceDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WorkExperienceDelete",
      requestType = proto.ServerClient.WorkExperienceFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo,
      com.google.protobuf.BoolValue> getWorkExperienceDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WorkExperienceFullInfo, com.google.protobuf.BoolValue> getWorkExperienceDeleteMethod;
    if ((getWorkExperienceDeleteMethod = WorkExperienceServiceGrpc.getWorkExperienceDeleteMethod) == null) {
      synchronized (WorkExperienceServiceGrpc.class) {
        if ((getWorkExperienceDeleteMethod = WorkExperienceServiceGrpc.getWorkExperienceDeleteMethod) == null) {
          WorkExperienceServiceGrpc.getWorkExperienceDeleteMethod = getWorkExperienceDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WorkExperienceFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WorkExperienceDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WorkExperienceFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new WorkExperienceServiceMethodDescriptorSupplier("WorkExperienceDelete"))
              .build();
        }
      }
    }
    return getWorkExperienceDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkExperienceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceStub>() {
        @java.lang.Override
        public WorkExperienceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkExperienceServiceStub(channel, callOptions);
        }
      };
    return WorkExperienceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkExperienceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceBlockingStub>() {
        @java.lang.Override
        public WorkExperienceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkExperienceServiceBlockingStub(channel, callOptions);
        }
      };
    return WorkExperienceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkExperienceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkExperienceServiceFutureStub>() {
        @java.lang.Override
        public WorkExperienceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkExperienceServiceFutureStub(channel, callOptions);
        }
      };
    return WorkExperienceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WorkExperienceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void workExperienceCreate(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWorkExperienceCreateMethod(), responseObserver);
    }

    /**
     */
    public void workExperienceRead(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWorkExperienceReadMethod(), responseObserver);
    }

    /**
     */
    public void workExperienceListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWorkExperienceListReadMethod(), responseObserver);
    }

    /**
     */
    public void workExperienceUpdateInfo(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWorkExperienceUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void workExperienceDelete(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWorkExperienceDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWorkExperienceCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WorkExperienceFullInfo,
                proto.ServerClient.WorkExperienceFullInfo>(
                  this, METHODID_WORK_EXPERIENCE_CREATE)))
          .addMethod(
            getWorkExperienceReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WorkExperienceFullInfo,
                proto.ServerClient.WorkExperienceFullInfo>(
                  this, METHODID_WORK_EXPERIENCE_READ)))
          .addMethod(
            getWorkExperienceListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.WorkExperienceFullInfo>(
                  this, METHODID_WORK_EXPERIENCE_LIST_READ)))
          .addMethod(
            getWorkExperienceUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WorkExperienceFullInfo,
                proto.ServerClient.WorkExperienceFullInfo>(
                  this, METHODID_WORK_EXPERIENCE_UPDATE_INFO)))
          .addMethod(
            getWorkExperienceDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WorkExperienceFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_WORK_EXPERIENCE_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class WorkExperienceServiceStub extends io.grpc.stub.AbstractAsyncStub<WorkExperienceServiceStub> {
    private WorkExperienceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkExperienceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkExperienceServiceStub(channel, callOptions);
    }

    /**
     */
    public void workExperienceCreate(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWorkExperienceCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void workExperienceRead(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWorkExperienceReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void workExperienceListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWorkExperienceListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void workExperienceUpdateInfo(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWorkExperienceUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void workExperienceDelete(proto.ServerClient.WorkExperienceFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWorkExperienceDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WorkExperienceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WorkExperienceServiceBlockingStub> {
    private WorkExperienceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkExperienceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkExperienceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.WorkExperienceFullInfo workExperienceCreate(proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWorkExperienceCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.WorkExperienceFullInfo workExperienceRead(proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWorkExperienceReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.WorkExperienceFullInfo> workExperienceListRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWorkExperienceListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.WorkExperienceFullInfo workExperienceUpdateInfo(proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWorkExperienceUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue workExperienceDelete(proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWorkExperienceDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WorkExperienceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WorkExperienceServiceFutureStub> {
    private WorkExperienceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkExperienceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkExperienceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WorkExperienceFullInfo> workExperienceCreate(
        proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWorkExperienceCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WorkExperienceFullInfo> workExperienceRead(
        proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWorkExperienceReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WorkExperienceFullInfo> workExperienceUpdateInfo(
        proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWorkExperienceUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> workExperienceDelete(
        proto.ServerClient.WorkExperienceFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWorkExperienceDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WORK_EXPERIENCE_CREATE = 0;
  private static final int METHODID_WORK_EXPERIENCE_READ = 1;
  private static final int METHODID_WORK_EXPERIENCE_LIST_READ = 2;
  private static final int METHODID_WORK_EXPERIENCE_UPDATE_INFO = 3;
  private static final int METHODID_WORK_EXPERIENCE_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkExperienceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkExperienceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WORK_EXPERIENCE_CREATE:
          serviceImpl.workExperienceCreate((proto.ServerClient.WorkExperienceFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo>) responseObserver);
          break;
        case METHODID_WORK_EXPERIENCE_READ:
          serviceImpl.workExperienceRead((proto.ServerClient.WorkExperienceFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo>) responseObserver);
          break;
        case METHODID_WORK_EXPERIENCE_LIST_READ:
          serviceImpl.workExperienceListRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo>) responseObserver);
          break;
        case METHODID_WORK_EXPERIENCE_UPDATE_INFO:
          serviceImpl.workExperienceUpdateInfo((proto.ServerClient.WorkExperienceFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WorkExperienceFullInfo>) responseObserver);
          break;
        case METHODID_WORK_EXPERIENCE_DELETE:
          serviceImpl.workExperienceDelete((proto.ServerClient.WorkExperienceFullInfo) request,
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

  private static abstract class WorkExperienceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkExperienceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkExperienceService");
    }
  }

  private static final class WorkExperienceServiceFileDescriptorSupplier
      extends WorkExperienceServiceBaseDescriptorSupplier {
    WorkExperienceServiceFileDescriptorSupplier() {}
  }

  private static final class WorkExperienceServiceMethodDescriptorSupplier
      extends WorkExperienceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkExperienceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkExperienceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkExperienceServiceFileDescriptorSupplier())
              .addMethod(getWorkExperienceCreateMethod())
              .addMethod(getWorkExperienceReadMethod())
              .addMethod(getWorkExperienceListReadMethod())
              .addMethod(getWorkExperienceUpdateInfoMethod())
              .addMethod(getWorkExperienceDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
