package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerChat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleCreate",
      requestType = proto.ServerChat.ScheduleFullInfo.class,
      responseType = proto.ServerChat.ScheduleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo> getScheduleCreateMethod;
    if ((getScheduleCreateMethod = ScheduleServiceGrpc.getScheduleCreateMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getScheduleCreateMethod = ScheduleServiceGrpc.getScheduleCreateMethod) == null) {
          ScheduleServiceGrpc.getScheduleCreateMethod = getScheduleCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ScheduleCreate"))
              .build();
        }
      }
    }
    return getScheduleCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleRead",
      requestType = proto.ServerChat.ScheduleFullInfo.class,
      responseType = proto.ServerChat.ScheduleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo> getScheduleReadMethod;
    if ((getScheduleReadMethod = ScheduleServiceGrpc.getScheduleReadMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getScheduleReadMethod = ScheduleServiceGrpc.getScheduleReadMethod) == null) {
          ScheduleServiceGrpc.getScheduleReadMethod = getScheduleReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ScheduleRead"))
              .build();
        }
      }
    }
    return getScheduleReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleListRead",
      requestType = proto.ServerChat.GroupMetaInfo.class,
      responseType = proto.ServerChat.ScheduleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo, proto.ServerChat.ScheduleFullInfo> getScheduleListReadMethod;
    if ((getScheduleListReadMethod = ScheduleServiceGrpc.getScheduleListReadMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getScheduleListReadMethod = ScheduleServiceGrpc.getScheduleListReadMethod) == null) {
          ScheduleServiceGrpc.getScheduleListReadMethod = getScheduleListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMetaInfo, proto.ServerChat.ScheduleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ScheduleListRead"))
              .build();
        }
      }
    }
    return getScheduleListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleUpdate",
      requestType = proto.ServerChat.ScheduleFullInfo.class,
      responseType = proto.ServerChat.ScheduleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      proto.ServerChat.ScheduleFullInfo> getScheduleUpdateMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo> getScheduleUpdateMethod;
    if ((getScheduleUpdateMethod = ScheduleServiceGrpc.getScheduleUpdateMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getScheduleUpdateMethod = ScheduleServiceGrpc.getScheduleUpdateMethod) == null) {
          ScheduleServiceGrpc.getScheduleUpdateMethod = getScheduleUpdateMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.ScheduleFullInfo, proto.ServerChat.ScheduleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ScheduleUpdate"))
              .build();
        }
      }
    }
    return getScheduleUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      com.google.protobuf.BoolValue> getScheduleDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleDelete",
      requestType = proto.ServerChat.ScheduleFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo,
      com.google.protobuf.BoolValue> getScheduleDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.ScheduleFullInfo, com.google.protobuf.BoolValue> getScheduleDeleteMethod;
    if ((getScheduleDeleteMethod = ScheduleServiceGrpc.getScheduleDeleteMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getScheduleDeleteMethod = ScheduleServiceGrpc.getScheduleDeleteMethod) == null) {
          ScheduleServiceGrpc.getScheduleDeleteMethod = getScheduleDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.ScheduleFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.ScheduleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ScheduleDelete"))
              .build();
        }
      }
    }
    return getScheduleDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub>() {
        @java.lang.Override
        public ScheduleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceStub(channel, callOptions);
        }
      };
    return ScheduleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub>() {
        @java.lang.Override
        public ScheduleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceBlockingStub(channel, callOptions);
        }
      };
    return ScheduleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub>() {
        @java.lang.Override
        public ScheduleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceFutureStub(channel, callOptions);
        }
      };
    return ScheduleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void scheduleCreate(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleCreateMethod(), responseObserver);
    }

    /**
     */
    public void scheduleRead(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleReadMethod(), responseObserver);
    }

    /**
     */
    public void scheduleListRead(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleListReadMethod(), responseObserver);
    }

    /**
     */
    public void scheduleUpdate(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleUpdateMethod(), responseObserver);
    }

    /**
     */
    public void scheduleDelete(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScheduleCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.ScheduleFullInfo,
                proto.ServerChat.ScheduleFullInfo>(
                  this, METHODID_SCHEDULE_CREATE)))
          .addMethod(
            getScheduleReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.ScheduleFullInfo,
                proto.ServerChat.ScheduleFullInfo>(
                  this, METHODID_SCHEDULE_READ)))
          .addMethod(
            getScheduleListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerChat.GroupMetaInfo,
                proto.ServerChat.ScheduleFullInfo>(
                  this, METHODID_SCHEDULE_LIST_READ)))
          .addMethod(
            getScheduleUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.ScheduleFullInfo,
                proto.ServerChat.ScheduleFullInfo>(
                  this, METHODID_SCHEDULE_UPDATE)))
          .addMethod(
            getScheduleDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.ScheduleFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_SCHEDULE_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ScheduleServiceStub extends io.grpc.stub.AbstractAsyncStub<ScheduleServiceStub> {
    private ScheduleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public void scheduleCreate(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleRead(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleListRead(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getScheduleListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleUpdate(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleDelete(proto.ServerChat.ScheduleFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ScheduleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerChat.ScheduleFullInfo scheduleCreate(proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerChat.ScheduleFullInfo scheduleRead(proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerChat.ScheduleFullInfo> scheduleListRead(
        proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getScheduleListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerChat.ScheduleFullInfo scheduleUpdate(proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue scheduleDelete(proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ScheduleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.ScheduleFullInfo> scheduleCreate(
        proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.ScheduleFullInfo> scheduleRead(
        proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.ScheduleFullInfo> scheduleUpdate(
        proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> scheduleDelete(
        proto.ServerChat.ScheduleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCHEDULE_CREATE = 0;
  private static final int METHODID_SCHEDULE_READ = 1;
  private static final int METHODID_SCHEDULE_LIST_READ = 2;
  private static final int METHODID_SCHEDULE_UPDATE = 3;
  private static final int METHODID_SCHEDULE_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScheduleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScheduleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCHEDULE_CREATE:
          serviceImpl.scheduleCreate((proto.ServerChat.ScheduleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo>) responseObserver);
          break;
        case METHODID_SCHEDULE_READ:
          serviceImpl.scheduleRead((proto.ServerChat.ScheduleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo>) responseObserver);
          break;
        case METHODID_SCHEDULE_LIST_READ:
          serviceImpl.scheduleListRead((proto.ServerChat.GroupMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo>) responseObserver);
          break;
        case METHODID_SCHEDULE_UPDATE:
          serviceImpl.scheduleUpdate((proto.ServerChat.ScheduleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.ScheduleFullInfo>) responseObserver);
          break;
        case METHODID_SCHEDULE_DELETE:
          serviceImpl.scheduleDelete((proto.ServerChat.ScheduleFullInfo) request,
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

  private static abstract class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerChat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScheduleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
              .addMethod(getScheduleCreateMethod())
              .addMethod(getScheduleReadMethod())
              .addMethod(getScheduleListReadMethod())
              .addMethod(getScheduleUpdateMethod())
              .addMethod(getScheduleDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
