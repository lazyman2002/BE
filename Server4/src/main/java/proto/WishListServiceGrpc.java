package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WishListServiceGrpc {

  private WishListServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.WishListService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WishListCreate",
      requestType = proto.ServerClient.WishListFullInfo.class,
      responseType = proto.ServerClient.WishListFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo, proto.ServerClient.WishListFullInfo> getWishListCreateMethod;
    if ((getWishListCreateMethod = WishListServiceGrpc.getWishListCreateMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getWishListCreateMethod = WishListServiceGrpc.getWishListCreateMethod) == null) {
          WishListServiceGrpc.getWishListCreateMethod = getWishListCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WishListFullInfo, proto.ServerClient.WishListFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WishListCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WishListFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WishListFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("WishListCreate"))
              .build();
        }
      }
    }
    return getWishListCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WishListRead",
      requestType = proto.ServerClient.UserFullInfo.class,
      responseType = proto.ServerClient.WishListFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo, proto.ServerClient.WishListFullInfo> getWishListReadMethod;
    if ((getWishListReadMethod = WishListServiceGrpc.getWishListReadMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getWishListReadMethod = WishListServiceGrpc.getWishListReadMethod) == null) {
          WishListServiceGrpc.getWishListReadMethod = getWishListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserFullInfo, proto.ServerClient.WishListFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WishListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WishListFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("WishListRead"))
              .build();
        }
      }
    }
    return getWishListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WishListUpdateInfo",
      requestType = proto.ServerClient.WishListFullInfo.class,
      responseType = proto.ServerClient.WishListFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo,
      proto.ServerClient.WishListFullInfo> getWishListUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.WishListFullInfo, proto.ServerClient.WishListFullInfo> getWishListUpdateInfoMethod;
    if ((getWishListUpdateInfoMethod = WishListServiceGrpc.getWishListUpdateInfoMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getWishListUpdateInfoMethod = WishListServiceGrpc.getWishListUpdateInfoMethod) == null) {
          WishListServiceGrpc.getWishListUpdateInfoMethod = getWishListUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.WishListFullInfo, proto.ServerClient.WishListFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WishListUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WishListFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.WishListFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("WishListUpdateInfo"))
              .build();
        }
      }
    }
    return getWishListUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      com.google.protobuf.BoolValue> getWishListDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WishListDelete",
      requestType = proto.ServerClient.UserFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      com.google.protobuf.BoolValue> getWishListDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo, com.google.protobuf.BoolValue> getWishListDeleteMethod;
    if ((getWishListDeleteMethod = WishListServiceGrpc.getWishListDeleteMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getWishListDeleteMethod = WishListServiceGrpc.getWishListDeleteMethod) == null) {
          WishListServiceGrpc.getWishListDeleteMethod = getWishListDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WishListDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("WishListDelete"))
              .build();
        }
      }
    }
    return getWishListDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.google.protobuf.Int32Value> getRecommendationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recommendation",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = com.google.protobuf.Int32Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.google.protobuf.Int32Value> getRecommendationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.google.protobuf.Int32Value> getRecommendationMethod;
    if ((getRecommendationMethod = WishListServiceGrpc.getRecommendationMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getRecommendationMethod = WishListServiceGrpc.getRecommendationMethod) == null) {
          WishListServiceGrpc.getRecommendationMethod = getRecommendationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.google.protobuf.Int32Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recommendation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("Recommendation"))
              .build();
        }
      }
    }
    return getRecommendationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getUpdateJobVectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateJobVector",
      requestType = proto.ServerClient.JobRequestFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo,
      com.google.protobuf.BoolValue> getUpdateJobVectorMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue> getUpdateJobVectorMethod;
    if ((getUpdateJobVectorMethod = WishListServiceGrpc.getUpdateJobVectorMethod) == null) {
      synchronized (WishListServiceGrpc.class) {
        if ((getUpdateJobVectorMethod = WishListServiceGrpc.getUpdateJobVectorMethod) == null) {
          WishListServiceGrpc.getUpdateJobVectorMethod = getUpdateJobVectorMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.JobRequestFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateJobVector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.JobRequestFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new WishListServiceMethodDescriptorSupplier("updateJobVector"))
              .build();
        }
      }
    }
    return getUpdateJobVectorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WishListServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WishListServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WishListServiceStub>() {
        @java.lang.Override
        public WishListServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WishListServiceStub(channel, callOptions);
        }
      };
    return WishListServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WishListServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WishListServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WishListServiceBlockingStub>() {
        @java.lang.Override
        public WishListServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WishListServiceBlockingStub(channel, callOptions);
        }
      };
    return WishListServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WishListServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WishListServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WishListServiceFutureStub>() {
        @java.lang.Override
        public WishListServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WishListServiceFutureStub(channel, callOptions);
        }
      };
    return WishListServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WishListServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void wishListCreate(proto.ServerClient.WishListFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWishListCreateMethod(), responseObserver);
    }

    /**
     */
    public void wishListRead(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWishListReadMethod(), responseObserver);
    }

    /**
     */
    public void wishListUpdateInfo(proto.ServerClient.WishListFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWishListUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void wishListDelete(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWishListDeleteMethod(), responseObserver);
    }

    /**
     */
    public void recommendation(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecommendationMethod(), responseObserver);
    }

    /**
     */
    public void updateJobVector(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobVectorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWishListCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WishListFullInfo,
                proto.ServerClient.WishListFullInfo>(
                  this, METHODID_WISH_LIST_CREATE)))
          .addMethod(
            getWishListReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserFullInfo,
                proto.ServerClient.WishListFullInfo>(
                  this, METHODID_WISH_LIST_READ)))
          .addMethod(
            getWishListUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.WishListFullInfo,
                proto.ServerClient.WishListFullInfo>(
                  this, METHODID_WISH_LIST_UPDATE_INFO)))
          .addMethod(
            getWishListDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_WISH_LIST_DELETE)))
          .addMethod(
            getRecommendationMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                com.google.protobuf.Int32Value>(
                  this, METHODID_RECOMMENDATION)))
          .addMethod(
            getUpdateJobVectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.JobRequestFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_UPDATE_JOB_VECTOR)))
          .build();
    }
  }

  /**
   */
  public static final class WishListServiceStub extends io.grpc.stub.AbstractAsyncStub<WishListServiceStub> {
    private WishListServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishListServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WishListServiceStub(channel, callOptions);
    }

    /**
     */
    public void wishListCreate(proto.ServerClient.WishListFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWishListCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void wishListRead(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWishListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void wishListUpdateInfo(proto.ServerClient.WishListFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWishListUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void wishListDelete(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWishListDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recommendation(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRecommendationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateJobVector(proto.ServerClient.JobRequestFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobVectorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WishListServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WishListServiceBlockingStub> {
    private WishListServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishListServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WishListServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.WishListFullInfo wishListCreate(proto.ServerClient.WishListFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWishListCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.WishListFullInfo wishListRead(proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWishListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.WishListFullInfo wishListUpdateInfo(proto.ServerClient.WishListFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWishListUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue wishListDelete(proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWishListDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.Int32Value> recommendation(
        com.google.protobuf.Int32Value request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRecommendationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue updateJobVector(proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobVectorMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WishListServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WishListServiceFutureStub> {
    private WishListServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishListServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WishListServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WishListFullInfo> wishListCreate(
        proto.ServerClient.WishListFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWishListCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WishListFullInfo> wishListRead(
        proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWishListReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.WishListFullInfo> wishListUpdateInfo(
        proto.ServerClient.WishListFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWishListUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> wishListDelete(
        proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWishListDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> updateJobVector(
        proto.ServerClient.JobRequestFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobVectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WISH_LIST_CREATE = 0;
  private static final int METHODID_WISH_LIST_READ = 1;
  private static final int METHODID_WISH_LIST_UPDATE_INFO = 2;
  private static final int METHODID_WISH_LIST_DELETE = 3;
  private static final int METHODID_RECOMMENDATION = 4;
  private static final int METHODID_UPDATE_JOB_VECTOR = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WishListServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WishListServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WISH_LIST_CREATE:
          serviceImpl.wishListCreate((proto.ServerClient.WishListFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo>) responseObserver);
          break;
        case METHODID_WISH_LIST_READ:
          serviceImpl.wishListRead((proto.ServerClient.UserFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo>) responseObserver);
          break;
        case METHODID_WISH_LIST_UPDATE_INFO:
          serviceImpl.wishListUpdateInfo((proto.ServerClient.WishListFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.WishListFullInfo>) responseObserver);
          break;
        case METHODID_WISH_LIST_DELETE:
          serviceImpl.wishListDelete((proto.ServerClient.UserFullInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_RECOMMENDATION:
          serviceImpl.recommendation((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value>) responseObserver);
          break;
        case METHODID_UPDATE_JOB_VECTOR:
          serviceImpl.updateJobVector((proto.ServerClient.JobRequestFullInfo) request,
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

  private static abstract class WishListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WishListServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WishListService");
    }
  }

  private static final class WishListServiceFileDescriptorSupplier
      extends WishListServiceBaseDescriptorSupplier {
    WishListServiceFileDescriptorSupplier() {}
  }

  private static final class WishListServiceMethodDescriptorSupplier
      extends WishListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WishListServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WishListServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WishListServiceFileDescriptorSupplier())
              .addMethod(getWishListCreateMethod())
              .addMethod(getWishListReadMethod())
              .addMethod(getWishListUpdateInfoMethod())
              .addMethod(getWishListDeleteMethod())
              .addMethod(getRecommendationMethod())
              .addMethod(getUpdateJobVectorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
