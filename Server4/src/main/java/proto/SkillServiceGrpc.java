package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SkillServiceGrpc {

  private SkillServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.SkillService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SkillCreate",
      requestType = proto.ServerClient.SkillFullInfo.class,
      responseType = proto.ServerClient.SkillFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo> getSkillCreateMethod;
    if ((getSkillCreateMethod = SkillServiceGrpc.getSkillCreateMethod) == null) {
      synchronized (SkillServiceGrpc.class) {
        if ((getSkillCreateMethod = SkillServiceGrpc.getSkillCreateMethod) == null) {
          SkillServiceGrpc.getSkillCreateMethod = getSkillCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SkillCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SkillServiceMethodDescriptorSupplier("SkillCreate"))
              .build();
        }
      }
    }
    return getSkillCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SkillRead",
      requestType = proto.ServerClient.SkillFullInfo.class,
      responseType = proto.ServerClient.SkillFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo> getSkillReadMethod;
    if ((getSkillReadMethod = SkillServiceGrpc.getSkillReadMethod) == null) {
      synchronized (SkillServiceGrpc.class) {
        if ((getSkillReadMethod = SkillServiceGrpc.getSkillReadMethod) == null) {
          SkillServiceGrpc.getSkillReadMethod = getSkillReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SkillRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SkillServiceMethodDescriptorSupplier("SkillRead"))
              .build();
        }
      }
    }
    return getSkillReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo,
      proto.ServerClient.SkillFullInfo> getSkillListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SkillListRead",
      requestType = proto.ServerClient.CVMetaInfo.class,
      responseType = proto.ServerClient.SkillFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo,
      proto.ServerClient.SkillFullInfo> getSkillListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo, proto.ServerClient.SkillFullInfo> getSkillListReadMethod;
    if ((getSkillListReadMethod = SkillServiceGrpc.getSkillListReadMethod) == null) {
      synchronized (SkillServiceGrpc.class) {
        if ((getSkillListReadMethod = SkillServiceGrpc.getSkillListReadMethod) == null) {
          SkillServiceGrpc.getSkillListReadMethod = getSkillListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVMetaInfo, proto.ServerClient.SkillFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SkillListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SkillServiceMethodDescriptorSupplier("SkillListRead"))
              .build();
        }
      }
    }
    return getSkillListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SkillUpdateInfo",
      requestType = proto.ServerClient.SkillFullInfo.class,
      responseType = proto.ServerClient.SkillFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      proto.ServerClient.SkillFullInfo> getSkillUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo> getSkillUpdateInfoMethod;
    if ((getSkillUpdateInfoMethod = SkillServiceGrpc.getSkillUpdateInfoMethod) == null) {
      synchronized (SkillServiceGrpc.class) {
        if ((getSkillUpdateInfoMethod = SkillServiceGrpc.getSkillUpdateInfoMethod) == null) {
          SkillServiceGrpc.getSkillUpdateInfoMethod = getSkillUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.SkillFullInfo, proto.ServerClient.SkillFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SkillUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SkillServiceMethodDescriptorSupplier("SkillUpdateInfo"))
              .build();
        }
      }
    }
    return getSkillUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      com.google.protobuf.BoolValue> getSkillDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SkillDelete",
      requestType = proto.ServerClient.SkillFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo,
      com.google.protobuf.BoolValue> getSkillDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.SkillFullInfo, com.google.protobuf.BoolValue> getSkillDeleteMethod;
    if ((getSkillDeleteMethod = SkillServiceGrpc.getSkillDeleteMethod) == null) {
      synchronized (SkillServiceGrpc.class) {
        if ((getSkillDeleteMethod = SkillServiceGrpc.getSkillDeleteMethod) == null) {
          SkillServiceGrpc.getSkillDeleteMethod = getSkillDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.SkillFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SkillDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.SkillFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new SkillServiceMethodDescriptorSupplier("SkillDelete"))
              .build();
        }
      }
    }
    return getSkillDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SkillServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SkillServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SkillServiceStub>() {
        @java.lang.Override
        public SkillServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SkillServiceStub(channel, callOptions);
        }
      };
    return SkillServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SkillServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SkillServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SkillServiceBlockingStub>() {
        @java.lang.Override
        public SkillServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SkillServiceBlockingStub(channel, callOptions);
        }
      };
    return SkillServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SkillServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SkillServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SkillServiceFutureStub>() {
        @java.lang.Override
        public SkillServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SkillServiceFutureStub(channel, callOptions);
        }
      };
    return SkillServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SkillServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void skillCreate(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkillCreateMethod(), responseObserver);
    }

    /**
     */
    public void skillRead(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkillReadMethod(), responseObserver);
    }

    /**
     */
    public void skillListRead(proto.ServerClient.CVMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkillListReadMethod(), responseObserver);
    }

    /**
     */
    public void skillUpdateInfo(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkillUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void skillDelete(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkillDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSkillCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.SkillFullInfo,
                proto.ServerClient.SkillFullInfo>(
                  this, METHODID_SKILL_CREATE)))
          .addMethod(
            getSkillReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.SkillFullInfo,
                proto.ServerClient.SkillFullInfo>(
                  this, METHODID_SKILL_READ)))
          .addMethod(
            getSkillListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVMetaInfo,
                proto.ServerClient.SkillFullInfo>(
                  this, METHODID_SKILL_LIST_READ)))
          .addMethod(
            getSkillUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.SkillFullInfo,
                proto.ServerClient.SkillFullInfo>(
                  this, METHODID_SKILL_UPDATE_INFO)))
          .addMethod(
            getSkillDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.SkillFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_SKILL_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SkillServiceStub extends io.grpc.stub.AbstractAsyncStub<SkillServiceStub> {
    private SkillServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SkillServiceStub(channel, callOptions);
    }

    /**
     */
    public void skillCreate(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkillCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void skillRead(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkillReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void skillListRead(proto.ServerClient.CVMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSkillListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void skillUpdateInfo(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkillUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void skillDelete(proto.ServerClient.SkillFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkillDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SkillServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SkillServiceBlockingStub> {
    private SkillServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SkillServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.SkillFullInfo skillCreate(proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkillCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.SkillFullInfo skillRead(proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkillReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.SkillFullInfo> skillListRead(
        proto.ServerClient.CVMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSkillListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.SkillFullInfo skillUpdateInfo(proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkillUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue skillDelete(proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkillDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SkillServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SkillServiceFutureStub> {
    private SkillServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SkillServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.SkillFullInfo> skillCreate(
        proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkillCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.SkillFullInfo> skillRead(
        proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkillReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.SkillFullInfo> skillUpdateInfo(
        proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkillUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> skillDelete(
        proto.ServerClient.SkillFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkillDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SKILL_CREATE = 0;
  private static final int METHODID_SKILL_READ = 1;
  private static final int METHODID_SKILL_LIST_READ = 2;
  private static final int METHODID_SKILL_UPDATE_INFO = 3;
  private static final int METHODID_SKILL_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SkillServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SkillServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SKILL_CREATE:
          serviceImpl.skillCreate((proto.ServerClient.SkillFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo>) responseObserver);
          break;
        case METHODID_SKILL_READ:
          serviceImpl.skillRead((proto.ServerClient.SkillFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo>) responseObserver);
          break;
        case METHODID_SKILL_LIST_READ:
          serviceImpl.skillListRead((proto.ServerClient.CVMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo>) responseObserver);
          break;
        case METHODID_SKILL_UPDATE_INFO:
          serviceImpl.skillUpdateInfo((proto.ServerClient.SkillFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.SkillFullInfo>) responseObserver);
          break;
        case METHODID_SKILL_DELETE:
          serviceImpl.skillDelete((proto.ServerClient.SkillFullInfo) request,
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

  private static abstract class SkillServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SkillServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SkillService");
    }
  }

  private static final class SkillServiceFileDescriptorSupplier
      extends SkillServiceBaseDescriptorSupplier {
    SkillServiceFileDescriptorSupplier() {}
  }

  private static final class SkillServiceMethodDescriptorSupplier
      extends SkillServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SkillServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SkillServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SkillServiceFileDescriptorSupplier())
              .addMethod(getSkillCreateMethod())
              .addMethod(getSkillReadMethod())
              .addMethod(getSkillListReadMethod())
              .addMethod(getSkillUpdateInfoMethod())
              .addMethod(getSkillDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
