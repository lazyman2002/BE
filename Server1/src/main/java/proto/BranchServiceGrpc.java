package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BranchServiceGrpc {

  private BranchServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.BranchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BranchCreate",
      requestType = proto.ServerClient.BranchFullInfo.class,
      responseType = proto.ServerClient.BranchFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo> getBranchCreateMethod;
    if ((getBranchCreateMethod = BranchServiceGrpc.getBranchCreateMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getBranchCreateMethod = BranchServiceGrpc.getBranchCreateMethod) == null) {
          BranchServiceGrpc.getBranchCreateMethod = getBranchCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BranchCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("BranchCreate"))
              .build();
        }
      }
    }
    return getBranchCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BranchRead",
      requestType = proto.ServerClient.BranchFullInfo.class,
      responseType = proto.ServerClient.BranchFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo> getBranchReadMethod;
    if ((getBranchReadMethod = BranchServiceGrpc.getBranchReadMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getBranchReadMethod = BranchServiceGrpc.getBranchReadMethod) == null) {
          BranchServiceGrpc.getBranchReadMethod = getBranchReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BranchRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("BranchRead"))
              .build();
        }
      }
    }
    return getBranchReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.BranchFullInfo> getBranchListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BranchListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.BranchFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.BranchFullInfo> getBranchListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.BranchFullInfo> getBranchListReadMethod;
    if ((getBranchListReadMethod = BranchServiceGrpc.getBranchListReadMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getBranchListReadMethod = BranchServiceGrpc.getBranchListReadMethod) == null) {
          BranchServiceGrpc.getBranchListReadMethod = getBranchListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.BranchFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BranchListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("BranchListRead"))
              .build();
        }
      }
    }
    return getBranchListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BranchUpdateInfo",
      requestType = proto.ServerClient.BranchFullInfo.class,
      responseType = proto.ServerClient.BranchFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      proto.ServerClient.BranchFullInfo> getBranchUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo> getBranchUpdateInfoMethod;
    if ((getBranchUpdateInfoMethod = BranchServiceGrpc.getBranchUpdateInfoMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getBranchUpdateInfoMethod = BranchServiceGrpc.getBranchUpdateInfoMethod) == null) {
          BranchServiceGrpc.getBranchUpdateInfoMethod = getBranchUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.BranchFullInfo, proto.ServerClient.BranchFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BranchUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("BranchUpdateInfo"))
              .build();
        }
      }
    }
    return getBranchUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      com.google.protobuf.BoolValue> getBranchDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BranchDelete",
      requestType = proto.ServerClient.BranchFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo,
      com.google.protobuf.BoolValue> getBranchDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.BranchFullInfo, com.google.protobuf.BoolValue> getBranchDeleteMethod;
    if ((getBranchDeleteMethod = BranchServiceGrpc.getBranchDeleteMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getBranchDeleteMethod = BranchServiceGrpc.getBranchDeleteMethod) == null) {
          BranchServiceGrpc.getBranchDeleteMethod = getBranchDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.BranchFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BranchDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.BranchFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("BranchDelete"))
              .build();
        }
      }
    }
    return getBranchDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BranchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BranchServiceStub>() {
        @java.lang.Override
        public BranchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BranchServiceStub(channel, callOptions);
        }
      };
    return BranchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BranchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BranchServiceBlockingStub>() {
        @java.lang.Override
        public BranchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BranchServiceBlockingStub(channel, callOptions);
        }
      };
    return BranchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BranchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BranchServiceFutureStub>() {
        @java.lang.Override
        public BranchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BranchServiceFutureStub(channel, callOptions);
        }
      };
    return BranchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BranchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void branchCreate(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBranchCreateMethod(), responseObserver);
    }

    /**
     */
    public void branchRead(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBranchReadMethod(), responseObserver);
    }

    /**
     */
    public void branchListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBranchListReadMethod(), responseObserver);
    }

    /**
     */
    public void branchUpdateInfo(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBranchUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void branchDelete(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBranchDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBranchCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.BranchFullInfo,
                proto.ServerClient.BranchFullInfo>(
                  this, METHODID_BRANCH_CREATE)))
          .addMethod(
            getBranchReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.BranchFullInfo,
                proto.ServerClient.BranchFullInfo>(
                  this, METHODID_BRANCH_READ)))
          .addMethod(
            getBranchListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.BranchFullInfo>(
                  this, METHODID_BRANCH_LIST_READ)))
          .addMethod(
            getBranchUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.BranchFullInfo,
                proto.ServerClient.BranchFullInfo>(
                  this, METHODID_BRANCH_UPDATE_INFO)))
          .addMethod(
            getBranchDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.BranchFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_BRANCH_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class BranchServiceStub extends io.grpc.stub.AbstractAsyncStub<BranchServiceStub> {
    private BranchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceStub(channel, callOptions);
    }

    /**
     */
    public void branchCreate(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBranchCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void branchRead(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBranchReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void branchListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBranchListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void branchUpdateInfo(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBranchUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void branchDelete(proto.ServerClient.BranchFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBranchDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BranchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BranchServiceBlockingStub> {
    private BranchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.BranchFullInfo branchCreate(proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBranchCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.BranchFullInfo branchRead(proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBranchReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.BranchFullInfo> branchListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBranchListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.BranchFullInfo branchUpdateInfo(proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBranchUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue branchDelete(proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBranchDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BranchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BranchServiceFutureStub> {
    private BranchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.BranchFullInfo> branchCreate(
        proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBranchCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.BranchFullInfo> branchRead(
        proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBranchReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.BranchFullInfo> branchUpdateInfo(
        proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBranchUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> branchDelete(
        proto.ServerClient.BranchFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBranchDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BRANCH_CREATE = 0;
  private static final int METHODID_BRANCH_READ = 1;
  private static final int METHODID_BRANCH_LIST_READ = 2;
  private static final int METHODID_BRANCH_UPDATE_INFO = 3;
  private static final int METHODID_BRANCH_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BranchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BranchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BRANCH_CREATE:
          serviceImpl.branchCreate((proto.ServerClient.BranchFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo>) responseObserver);
          break;
        case METHODID_BRANCH_READ:
          serviceImpl.branchRead((proto.ServerClient.BranchFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo>) responseObserver);
          break;
        case METHODID_BRANCH_LIST_READ:
          serviceImpl.branchListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo>) responseObserver);
          break;
        case METHODID_BRANCH_UPDATE_INFO:
          serviceImpl.branchUpdateInfo((proto.ServerClient.BranchFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.BranchFullInfo>) responseObserver);
          break;
        case METHODID_BRANCH_DELETE:
          serviceImpl.branchDelete((proto.ServerClient.BranchFullInfo) request,
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

  private static abstract class BranchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BranchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BranchService");
    }
  }

  private static final class BranchServiceFileDescriptorSupplier
      extends BranchServiceBaseDescriptorSupplier {
    BranchServiceFileDescriptorSupplier() {}
  }

  private static final class BranchServiceMethodDescriptorSupplier
      extends BranchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BranchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BranchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BranchServiceFileDescriptorSupplier())
              .addMethod(getBranchCreateMethod())
              .addMethod(getBranchReadMethod())
              .addMethod(getBranchListReadMethod())
              .addMethod(getBranchUpdateInfoMethod())
              .addMethod(getBranchDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
