package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CVServiceGrpc {

  private CVServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CVService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CVCreate",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.CVFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo> getCVCreateMethod;
    if ((getCVCreateMethod = CVServiceGrpc.getCVCreateMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getCVCreateMethod = CVServiceGrpc.getCVCreateMethod) == null) {
          CVServiceGrpc.getCVCreateMethod = getCVCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CVCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("CVCreate"))
              .build();
        }
      }
    }
    return getCVCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CVRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.CVFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo> getCVReadMethod;
    if ((getCVReadMethod = CVServiceGrpc.getCVReadMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getCVReadMethod = CVServiceGrpc.getCVReadMethod) == null) {
          CVServiceGrpc.getCVReadMethod = getCVReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CVRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("CVRead"))
              .build();
        }
      }
    }
    return getCVReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.CVFullInfo> getCVListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CVListRead",
      requestType = proto.ServerClient.UserFullInfo.class,
      responseType = proto.ServerClient.CVFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.CVFullInfo> getCVListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo, proto.ServerClient.CVFullInfo> getCVListReadMethod;
    if ((getCVListReadMethod = CVServiceGrpc.getCVListReadMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getCVListReadMethod = CVServiceGrpc.getCVListReadMethod) == null) {
          CVServiceGrpc.getCVListReadMethod = getCVListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserFullInfo, proto.ServerClient.CVFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CVListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("CVListRead"))
              .build();
        }
      }
    }
    return getCVListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CVUpdateInfo",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.CVFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.CVFullInfo> getCVUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo> getCVUpdateInfoMethod;
    if ((getCVUpdateInfoMethod = CVServiceGrpc.getCVUpdateInfoMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getCVUpdateInfoMethod = CVServiceGrpc.getCVUpdateInfoMethod) == null) {
          CVServiceGrpc.getCVUpdateInfoMethod = getCVUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.CVFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CVUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("CVUpdateInfo"))
              .build();
        }
      }
    }
    return getCVUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      com.google.protobuf.BoolValue> getCVDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CVDelete",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      com.google.protobuf.BoolValue> getCVDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, com.google.protobuf.BoolValue> getCVDeleteMethod;
    if ((getCVDeleteMethod = CVServiceGrpc.getCVDeleteMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getCVDeleteMethod = CVServiceGrpc.getCVDeleteMethod) == null) {
          CVServiceGrpc.getCVDeleteMethod = getCVDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CVDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("CVDelete"))
              .build();
        }
      }
    }
    return getCVDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo,
      com.google.protobuf.BoolValue> getApplyCVMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyCV",
      requestType = proto.ServerClient.AppliesInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo,
      com.google.protobuf.BoolValue> getApplyCVMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo, com.google.protobuf.BoolValue> getApplyCVMethod;
    if ((getApplyCVMethod = CVServiceGrpc.getApplyCVMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getApplyCVMethod = CVServiceGrpc.getApplyCVMethod) == null) {
          CVServiceGrpc.getApplyCVMethod = getApplyCVMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AppliesInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyCV"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AppliesInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("ApplyCV"))
              .build();
        }
      }
    }
    return getApplyCVMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo,
      com.google.protobuf.BoolValue> getApplyStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyStatus",
      requestType = proto.ServerClient.AppliesInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo,
      com.google.protobuf.BoolValue> getApplyStatusMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.AppliesInfo, com.google.protobuf.BoolValue> getApplyStatusMethod;
    if ((getApplyStatusMethod = CVServiceGrpc.getApplyStatusMethod) == null) {
      synchronized (CVServiceGrpc.class) {
        if ((getApplyStatusMethod = CVServiceGrpc.getApplyStatusMethod) == null) {
          CVServiceGrpc.getApplyStatusMethod = getApplyStatusMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.AppliesInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.AppliesInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new CVServiceMethodDescriptorSupplier("ApplyStatus"))
              .build();
        }
      }
    }
    return getApplyStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CVServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CVServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CVServiceStub>() {
        @java.lang.Override
        public CVServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CVServiceStub(channel, callOptions);
        }
      };
    return CVServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CVServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CVServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CVServiceBlockingStub>() {
        @java.lang.Override
        public CVServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CVServiceBlockingStub(channel, callOptions);
        }
      };
    return CVServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CVServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CVServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CVServiceFutureStub>() {
        @java.lang.Override
        public CVServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CVServiceFutureStub(channel, callOptions);
        }
      };
    return CVServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CVServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void cVCreate(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVCreateMethod(), responseObserver);
    }

    /**
     */
    public void cVRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVReadMethod(), responseObserver);
    }

    /**
     */
    public void cVListRead(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVListReadMethod(), responseObserver);
    }

    /**
     */
    public void cVUpdateInfo(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void cVDelete(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCVDeleteMethod(), responseObserver);
    }

    /**
     */
    public void applyCV(proto.ServerClient.AppliesInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplyCVMethod(), responseObserver);
    }

    /**
     */
    public void applyStatus(proto.ServerClient.AppliesInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplyStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCVCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.CVFullInfo>(
                  this, METHODID_CVCREATE)))
          .addMethod(
            getCVReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.CVFullInfo>(
                  this, METHODID_CVREAD)))
          .addMethod(
            getCVListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.UserFullInfo,
                proto.ServerClient.CVFullInfo>(
                  this, METHODID_CVLIST_READ)))
          .addMethod(
            getCVUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.CVFullInfo>(
                  this, METHODID_CVUPDATE_INFO)))
          .addMethod(
            getCVDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_CVDELETE)))
          .addMethod(
            getApplyCVMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AppliesInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_APPLY_CV)))
          .addMethod(
            getApplyStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.AppliesInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_APPLY_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class CVServiceStub extends io.grpc.stub.AbstractAsyncStub<CVServiceStub> {
    private CVServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CVServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CVServiceStub(channel, callOptions);
    }

    /**
     */
    public void cVCreate(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCVCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cVRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCVReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cVListRead(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCVListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cVUpdateInfo(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCVUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cVDelete(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCVDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyCV(proto.ServerClient.AppliesInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyCVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyStatus(proto.ServerClient.AppliesInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CVServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CVServiceBlockingStub> {
    private CVServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CVServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CVServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.CVFullInfo cVCreate(proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCVCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CVFullInfo cVRead(proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCVReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CVFullInfo> cVListRead(
        proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCVListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CVFullInfo cVUpdateInfo(proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCVUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue cVDelete(proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCVDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue applyCV(proto.ServerClient.AppliesInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyCVMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue applyStatus(proto.ServerClient.AppliesInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CVServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CVServiceFutureStub> {
    private CVServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CVServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CVServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CVFullInfo> cVCreate(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCVCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CVFullInfo> cVRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCVReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CVFullInfo> cVUpdateInfo(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCVUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> cVDelete(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCVDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> applyCV(
        proto.ServerClient.AppliesInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyCVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> applyStatus(
        proto.ServerClient.AppliesInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CVCREATE = 0;
  private static final int METHODID_CVREAD = 1;
  private static final int METHODID_CVLIST_READ = 2;
  private static final int METHODID_CVUPDATE_INFO = 3;
  private static final int METHODID_CVDELETE = 4;
  private static final int METHODID_APPLY_CV = 5;
  private static final int METHODID_APPLY_STATUS = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CVServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CVServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CVCREATE:
          serviceImpl.cVCreate((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo>) responseObserver);
          break;
        case METHODID_CVREAD:
          serviceImpl.cVRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo>) responseObserver);
          break;
        case METHODID_CVLIST_READ:
          serviceImpl.cVListRead((proto.ServerClient.UserFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo>) responseObserver);
          break;
        case METHODID_CVUPDATE_INFO:
          serviceImpl.cVUpdateInfo((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CVFullInfo>) responseObserver);
          break;
        case METHODID_CVDELETE:
          serviceImpl.cVDelete((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_APPLY_CV:
          serviceImpl.applyCV((proto.ServerClient.AppliesInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_APPLY_STATUS:
          serviceImpl.applyStatus((proto.ServerClient.AppliesInfo) request,
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

  private static abstract class CVServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CVServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CVService");
    }
  }

  private static final class CVServiceFileDescriptorSupplier
      extends CVServiceBaseDescriptorSupplier {
    CVServiceFileDescriptorSupplier() {}
  }

  private static final class CVServiceMethodDescriptorSupplier
      extends CVServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CVServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CVServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CVServiceFileDescriptorSupplier())
              .addMethod(getCVCreateMethod())
              .addMethod(getCVReadMethod())
              .addMethod(getCVListReadMethod())
              .addMethod(getCVUpdateInfoMethod())
              .addMethod(getCVDeleteMethod())
              .addMethod(getApplyCVMethod())
              .addMethod(getApplyStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
