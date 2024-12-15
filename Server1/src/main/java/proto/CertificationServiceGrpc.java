package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CertificationServiceGrpc {

  private CertificationServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CertificationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CertificationCreate",
      requestType = proto.ServerClient.CertificationFullInfo.class,
      responseType = proto.ServerClient.CertificationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo> getCertificationCreateMethod;
    if ((getCertificationCreateMethod = CertificationServiceGrpc.getCertificationCreateMethod) == null) {
      synchronized (CertificationServiceGrpc.class) {
        if ((getCertificationCreateMethod = CertificationServiceGrpc.getCertificationCreateMethod) == null) {
          CertificationServiceGrpc.getCertificationCreateMethod = getCertificationCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CertificationCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CertificationServiceMethodDescriptorSupplier("CertificationCreate"))
              .build();
        }
      }
    }
    return getCertificationCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CertificationRead",
      requestType = proto.ServerClient.CertificationFullInfo.class,
      responseType = proto.ServerClient.CertificationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo> getCertificationReadMethod;
    if ((getCertificationReadMethod = CertificationServiceGrpc.getCertificationReadMethod) == null) {
      synchronized (CertificationServiceGrpc.class) {
        if ((getCertificationReadMethod = CertificationServiceGrpc.getCertificationReadMethod) == null) {
          CertificationServiceGrpc.getCertificationReadMethod = getCertificationReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CertificationRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CertificationServiceMethodDescriptorSupplier("CertificationRead"))
              .build();
        }
      }
    }
    return getCertificationReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CertificationListRead",
      requestType = proto.ServerClient.CVMetaInfo.class,
      responseType = proto.ServerClient.CertificationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVMetaInfo, proto.ServerClient.CertificationFullInfo> getCertificationListReadMethod;
    if ((getCertificationListReadMethod = CertificationServiceGrpc.getCertificationListReadMethod) == null) {
      synchronized (CertificationServiceGrpc.class) {
        if ((getCertificationListReadMethod = CertificationServiceGrpc.getCertificationListReadMethod) == null) {
          CertificationServiceGrpc.getCertificationListReadMethod = getCertificationListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVMetaInfo, proto.ServerClient.CertificationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CertificationListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CertificationServiceMethodDescriptorSupplier("CertificationListRead"))
              .build();
        }
      }
    }
    return getCertificationListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CertificationUpdateInfo",
      requestType = proto.ServerClient.CertificationFullInfo.class,
      responseType = proto.ServerClient.CertificationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      proto.ServerClient.CertificationFullInfo> getCertificationUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo> getCertificationUpdateInfoMethod;
    if ((getCertificationUpdateInfoMethod = CertificationServiceGrpc.getCertificationUpdateInfoMethod) == null) {
      synchronized (CertificationServiceGrpc.class) {
        if ((getCertificationUpdateInfoMethod = CertificationServiceGrpc.getCertificationUpdateInfoMethod) == null) {
          CertificationServiceGrpc.getCertificationUpdateInfoMethod = getCertificationUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CertificationFullInfo, proto.ServerClient.CertificationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CertificationUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CertificationServiceMethodDescriptorSupplier("CertificationUpdateInfo"))
              .build();
        }
      }
    }
    return getCertificationUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      com.google.protobuf.BoolValue> getCertificationDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CertificationDelete",
      requestType = proto.ServerClient.CertificationFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo,
      com.google.protobuf.BoolValue> getCertificationDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CertificationFullInfo, com.google.protobuf.BoolValue> getCertificationDeleteMethod;
    if ((getCertificationDeleteMethod = CertificationServiceGrpc.getCertificationDeleteMethod) == null) {
      synchronized (CertificationServiceGrpc.class) {
        if ((getCertificationDeleteMethod = CertificationServiceGrpc.getCertificationDeleteMethod) == null) {
          CertificationServiceGrpc.getCertificationDeleteMethod = getCertificationDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CertificationFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CertificationDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CertificationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new CertificationServiceMethodDescriptorSupplier("CertificationDelete"))
              .build();
        }
      }
    }
    return getCertificationDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CertificationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CertificationServiceStub>() {
        @java.lang.Override
        public CertificationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CertificationServiceStub(channel, callOptions);
        }
      };
    return CertificationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CertificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CertificationServiceBlockingStub>() {
        @java.lang.Override
        public CertificationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CertificationServiceBlockingStub(channel, callOptions);
        }
      };
    return CertificationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CertificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CertificationServiceFutureStub>() {
        @java.lang.Override
        public CertificationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CertificationServiceFutureStub(channel, callOptions);
        }
      };
    return CertificationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CertificationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void certificationCreate(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCertificationCreateMethod(), responseObserver);
    }

    /**
     */
    public void certificationRead(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCertificationReadMethod(), responseObserver);
    }

    /**
     */
    public void certificationListRead(proto.ServerClient.CVMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCertificationListReadMethod(), responseObserver);
    }

    /**
     */
    public void certificationUpdateInfo(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCertificationUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void certificationDelete(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCertificationDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCertificationCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CertificationFullInfo,
                proto.ServerClient.CertificationFullInfo>(
                  this, METHODID_CERTIFICATION_CREATE)))
          .addMethod(
            getCertificationReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CertificationFullInfo,
                proto.ServerClient.CertificationFullInfo>(
                  this, METHODID_CERTIFICATION_READ)))
          .addMethod(
            getCertificationListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVMetaInfo,
                proto.ServerClient.CertificationFullInfo>(
                  this, METHODID_CERTIFICATION_LIST_READ)))
          .addMethod(
            getCertificationUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CertificationFullInfo,
                proto.ServerClient.CertificationFullInfo>(
                  this, METHODID_CERTIFICATION_UPDATE_INFO)))
          .addMethod(
            getCertificationDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CertificationFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_CERTIFICATION_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class CertificationServiceStub extends io.grpc.stub.AbstractAsyncStub<CertificationServiceStub> {
    private CertificationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificationServiceStub(channel, callOptions);
    }

    /**
     */
    public void certificationCreate(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCertificationCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void certificationRead(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCertificationReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void certificationListRead(proto.ServerClient.CVMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCertificationListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void certificationUpdateInfo(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCertificationUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void certificationDelete(proto.ServerClient.CertificationFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCertificationDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CertificationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CertificationServiceBlockingStub> {
    private CertificationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.CertificationFullInfo certificationCreate(proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCertificationCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CertificationFullInfo certificationRead(proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCertificationReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CertificationFullInfo> certificationListRead(
        proto.ServerClient.CVMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCertificationListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CertificationFullInfo certificationUpdateInfo(proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCertificationUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue certificationDelete(proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCertificationDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CertificationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CertificationServiceFutureStub> {
    private CertificationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CertificationFullInfo> certificationCreate(
        proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCertificationCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CertificationFullInfo> certificationRead(
        proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCertificationReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CertificationFullInfo> certificationUpdateInfo(
        proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCertificationUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> certificationDelete(
        proto.ServerClient.CertificationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCertificationDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CERTIFICATION_CREATE = 0;
  private static final int METHODID_CERTIFICATION_READ = 1;
  private static final int METHODID_CERTIFICATION_LIST_READ = 2;
  private static final int METHODID_CERTIFICATION_UPDATE_INFO = 3;
  private static final int METHODID_CERTIFICATION_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CertificationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CertificationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CERTIFICATION_CREATE:
          serviceImpl.certificationCreate((proto.ServerClient.CertificationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo>) responseObserver);
          break;
        case METHODID_CERTIFICATION_READ:
          serviceImpl.certificationRead((proto.ServerClient.CertificationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo>) responseObserver);
          break;
        case METHODID_CERTIFICATION_LIST_READ:
          serviceImpl.certificationListRead((proto.ServerClient.CVMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo>) responseObserver);
          break;
        case METHODID_CERTIFICATION_UPDATE_INFO:
          serviceImpl.certificationUpdateInfo((proto.ServerClient.CertificationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CertificationFullInfo>) responseObserver);
          break;
        case METHODID_CERTIFICATION_DELETE:
          serviceImpl.certificationDelete((proto.ServerClient.CertificationFullInfo) request,
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

  private static abstract class CertificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CertificationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CertificationService");
    }
  }

  private static final class CertificationServiceFileDescriptorSupplier
      extends CertificationServiceBaseDescriptorSupplier {
    CertificationServiceFileDescriptorSupplier() {}
  }

  private static final class CertificationServiceMethodDescriptorSupplier
      extends CertificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CertificationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CertificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CertificationServiceFileDescriptorSupplier())
              .addMethod(getCertificationCreateMethod())
              .addMethod(getCertificationReadMethod())
              .addMethod(getCertificationListReadMethod())
              .addMethod(getCertificationUpdateInfoMethod())
              .addMethod(getCertificationDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
