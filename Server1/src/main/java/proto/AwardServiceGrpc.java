package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AwardServiceGrpc {

  private AwardServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.AwardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AwardCreate",
      requestType = proto.ServerClient.AwardFullInfo.class,
      responseType = proto.ServerClient.AwardFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo> getAwardCreateMethod;
    if ((getAwardCreateMethod = AwardServiceGrpc.getAwardCreateMethod) == null) {
      synchronized (AwardServiceGrpc.class) {
        if ((getAwardCreateMethod = AwardServiceGrpc.getAwardCreateMethod) == null) {
          AwardServiceGrpc.getAwardCreateMethod = getAwardCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AwardCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new AwardServiceMethodDescriptorSupplier("AwardCreate"))
              .build();
        }
      }
    }
    return getAwardCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AwardRead",
      requestType = proto.ServerClient.AwardFullInfo.class,
      responseType = proto.ServerClient.AwardFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo> getAwardReadMethod;
    if ((getAwardReadMethod = AwardServiceGrpc.getAwardReadMethod) == null) {
      synchronized (AwardServiceGrpc.class) {
        if ((getAwardReadMethod = AwardServiceGrpc.getAwardReadMethod) == null) {
          AwardServiceGrpc.getAwardReadMethod = getAwardReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AwardRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new AwardServiceMethodDescriptorSupplier("AwardRead"))
              .build();
        }
      }
    }
    return getAwardReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AwardListRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.AwardFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.AwardFullInfo> getAwardListReadMethod;
    if ((getAwardListReadMethod = AwardServiceGrpc.getAwardListReadMethod) == null) {
      synchronized (AwardServiceGrpc.class) {
        if ((getAwardListReadMethod = AwardServiceGrpc.getAwardListReadMethod) == null) {
          AwardServiceGrpc.getAwardListReadMethod = getAwardListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.AwardFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AwardListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new AwardServiceMethodDescriptorSupplier("AwardListRead"))
              .build();
        }
      }
    }
    return getAwardListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AwardUpdateInfo",
      requestType = proto.ServerClient.AwardFullInfo.class,
      responseType = proto.ServerClient.AwardFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      proto.ServerClient.AwardFullInfo> getAwardUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo> getAwardUpdateInfoMethod;
    if ((getAwardUpdateInfoMethod = AwardServiceGrpc.getAwardUpdateInfoMethod) == null) {
      synchronized (AwardServiceGrpc.class) {
        if ((getAwardUpdateInfoMethod = AwardServiceGrpc.getAwardUpdateInfoMethod) == null) {
          AwardServiceGrpc.getAwardUpdateInfoMethod = getAwardUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AwardFullInfo, proto.ServerClient.AwardFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AwardUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new AwardServiceMethodDescriptorSupplier("AwardUpdateInfo"))
              .build();
        }
      }
    }
    return getAwardUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      com.google.protobuf.BoolValue> getAwardDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AwardDelete",
      requestType = proto.ServerClient.AwardFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo,
      com.google.protobuf.BoolValue> getAwardDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AwardFullInfo, com.google.protobuf.BoolValue> getAwardDeleteMethod;
    if ((getAwardDeleteMethod = AwardServiceGrpc.getAwardDeleteMethod) == null) {
      synchronized (AwardServiceGrpc.class) {
        if ((getAwardDeleteMethod = AwardServiceGrpc.getAwardDeleteMethod) == null) {
          AwardServiceGrpc.getAwardDeleteMethod = getAwardDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AwardFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AwardDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AwardFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new AwardServiceMethodDescriptorSupplier("AwardDelete"))
              .build();
        }
      }
    }
    return getAwardDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AwardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwardServiceStub>() {
        @java.lang.Override
        public AwardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwardServiceStub(channel, callOptions);
        }
      };
    return AwardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AwardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwardServiceBlockingStub>() {
        @java.lang.Override
        public AwardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwardServiceBlockingStub(channel, callOptions);
        }
      };
    return AwardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AwardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwardServiceFutureStub>() {
        @java.lang.Override
        public AwardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwardServiceFutureStub(channel, callOptions);
        }
      };
    return AwardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AwardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void awardCreate(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAwardCreateMethod(), responseObserver);
    }

    /**
     */
    public void awardRead(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAwardReadMethod(), responseObserver);
    }

    /**
     */
    public void awardListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAwardListReadMethod(), responseObserver);
    }

    /**
     */
    public void awardUpdateInfo(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAwardUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void awardDelete(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAwardDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAwardCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AwardFullInfo,
                proto.ServerClient.AwardFullInfo>(
                  this, METHODID_AWARD_CREATE)))
          .addMethod(
            getAwardReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AwardFullInfo,
                proto.ServerClient.AwardFullInfo>(
                  this, METHODID_AWARD_READ)))
          .addMethod(
            getAwardListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.AwardFullInfo>(
                  this, METHODID_AWARD_LIST_READ)))
          .addMethod(
            getAwardUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AwardFullInfo,
                proto.ServerClient.AwardFullInfo>(
                  this, METHODID_AWARD_UPDATE_INFO)))
          .addMethod(
            getAwardDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AwardFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_AWARD_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class AwardServiceStub extends io.grpc.stub.AbstractAsyncStub<AwardServiceStub> {
    private AwardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwardServiceStub(channel, callOptions);
    }

    /**
     */
    public void awardCreate(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAwardCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void awardRead(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAwardReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void awardListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAwardListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void awardUpdateInfo(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAwardUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void awardDelete(proto.ServerClient.AwardFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAwardDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AwardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AwardServiceBlockingStub> {
    private AwardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.AwardFullInfo awardCreate(proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAwardCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.AwardFullInfo awardRead(proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAwardReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.AwardFullInfo> awardListRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAwardListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.AwardFullInfo awardUpdateInfo(proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAwardUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue awardDelete(proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAwardDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AwardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AwardServiceFutureStub> {
    private AwardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.AwardFullInfo> awardCreate(
        proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAwardCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.AwardFullInfo> awardRead(
        proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAwardReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.AwardFullInfo> awardUpdateInfo(
        proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAwardUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> awardDelete(
        proto.ServerClient.AwardFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAwardDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AWARD_CREATE = 0;
  private static final int METHODID_AWARD_READ = 1;
  private static final int METHODID_AWARD_LIST_READ = 2;
  private static final int METHODID_AWARD_UPDATE_INFO = 3;
  private static final int METHODID_AWARD_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AwardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AwardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AWARD_CREATE:
          serviceImpl.awardCreate((proto.ServerClient.AwardFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo>) responseObserver);
          break;
        case METHODID_AWARD_READ:
          serviceImpl.awardRead((proto.ServerClient.AwardFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo>) responseObserver);
          break;
        case METHODID_AWARD_LIST_READ:
          serviceImpl.awardListRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo>) responseObserver);
          break;
        case METHODID_AWARD_UPDATE_INFO:
          serviceImpl.awardUpdateInfo((proto.ServerClient.AwardFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.AwardFullInfo>) responseObserver);
          break;
        case METHODID_AWARD_DELETE:
          serviceImpl.awardDelete((proto.ServerClient.AwardFullInfo) request,
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

  private static abstract class AwardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AwardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AwardService");
    }
  }

  private static final class AwardServiceFileDescriptorSupplier
      extends AwardServiceBaseDescriptorSupplier {
    AwardServiceFileDescriptorSupplier() {}
  }

  private static final class AwardServiceMethodDescriptorSupplier
      extends AwardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AwardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AwardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AwardServiceFileDescriptorSupplier())
              .addMethod(getAwardCreateMethod())
              .addMethod(getAwardReadMethod())
              .addMethod(getAwardListReadMethod())
              .addMethod(getAwardUpdateInfoMethod())
              .addMethod(getAwardDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
