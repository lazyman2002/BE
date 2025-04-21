package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EducationServiceGrpc {

  private EducationServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.EducationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EducationCreate",
      requestType = proto.ServerClient.EducationFullInfo.class,
      responseType = proto.ServerClient.EducationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo> getEducationCreateMethod;
    if ((getEducationCreateMethod = EducationServiceGrpc.getEducationCreateMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEducationCreateMethod = EducationServiceGrpc.getEducationCreateMethod) == null) {
          EducationServiceGrpc.getEducationCreateMethod = getEducationCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EducationCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("EducationCreate"))
              .build();
        }
      }
    }
    return getEducationCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EducationRead",
      requestType = proto.ServerClient.EducationFullInfo.class,
      responseType = proto.ServerClient.EducationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo> getEducationReadMethod;
    if ((getEducationReadMethod = EducationServiceGrpc.getEducationReadMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEducationReadMethod = EducationServiceGrpc.getEducationReadMethod) == null) {
          EducationServiceGrpc.getEducationReadMethod = getEducationReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EducationRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("EducationRead"))
              .build();
        }
      }
    }
    return getEducationReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EducationListRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.EducationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.EducationFullInfo> getEducationListReadMethod;
    if ((getEducationListReadMethod = EducationServiceGrpc.getEducationListReadMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEducationListReadMethod = EducationServiceGrpc.getEducationListReadMethod) == null) {
          EducationServiceGrpc.getEducationListReadMethod = getEducationListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.EducationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EducationListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("EducationListRead"))
              .build();
        }
      }
    }
    return getEducationListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EducationUpdateInfo",
      requestType = proto.ServerClient.EducationFullInfo.class,
      responseType = proto.ServerClient.EducationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      proto.ServerClient.EducationFullInfo> getEducationUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo> getEducationUpdateInfoMethod;
    if ((getEducationUpdateInfoMethod = EducationServiceGrpc.getEducationUpdateInfoMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEducationUpdateInfoMethod = EducationServiceGrpc.getEducationUpdateInfoMethod) == null) {
          EducationServiceGrpc.getEducationUpdateInfoMethod = getEducationUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.EducationFullInfo, proto.ServerClient.EducationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EducationUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("EducationUpdateInfo"))
              .build();
        }
      }
    }
    return getEducationUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      com.google.protobuf.BoolValue> getEducationDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EducationDelete",
      requestType = proto.ServerClient.EducationFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo,
      com.google.protobuf.BoolValue> getEducationDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.EducationFullInfo, com.google.protobuf.BoolValue> getEducationDeleteMethod;
    if ((getEducationDeleteMethod = EducationServiceGrpc.getEducationDeleteMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEducationDeleteMethod = EducationServiceGrpc.getEducationDeleteMethod) == null) {
          EducationServiceGrpc.getEducationDeleteMethod = getEducationDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.EducationFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EducationDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.EducationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("EducationDelete"))
              .build();
        }
      }
    }
    return getEducationDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EducationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceStub>() {
        @java.lang.Override
        public EducationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceStub(channel, callOptions);
        }
      };
    return EducationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EducationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceBlockingStub>() {
        @java.lang.Override
        public EducationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceBlockingStub(channel, callOptions);
        }
      };
    return EducationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EducationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceFutureStub>() {
        @java.lang.Override
        public EducationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceFutureStub(channel, callOptions);
        }
      };
    return EducationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EducationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void educationCreate(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEducationCreateMethod(), responseObserver);
    }

    /**
     */
    public void educationRead(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEducationReadMethod(), responseObserver);
    }

    /**
     */
    public void educationListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEducationListReadMethod(), responseObserver);
    }

    /**
     */
    public void educationUpdateInfo(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEducationUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void educationDelete(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEducationDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEducationCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.EducationFullInfo,
                proto.ServerClient.EducationFullInfo>(
                  this, METHODID_EDUCATION_CREATE)))
          .addMethod(
            getEducationReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.EducationFullInfo,
                proto.ServerClient.EducationFullInfo>(
                  this, METHODID_EDUCATION_READ)))
          .addMethod(
            getEducationListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.EducationFullInfo>(
                  this, METHODID_EDUCATION_LIST_READ)))
          .addMethod(
            getEducationUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.EducationFullInfo,
                proto.ServerClient.EducationFullInfo>(
                  this, METHODID_EDUCATION_UPDATE_INFO)))
          .addMethod(
            getEducationDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.EducationFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_EDUCATION_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class EducationServiceStub extends io.grpc.stub.AbstractAsyncStub<EducationServiceStub> {
    private EducationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceStub(channel, callOptions);
    }

    /**
     */
    public void educationCreate(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEducationCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void educationRead(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEducationReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void educationListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getEducationListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void educationUpdateInfo(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEducationUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void educationDelete(proto.ServerClient.EducationFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEducationDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EducationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EducationServiceBlockingStub> {
    private EducationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.EducationFullInfo educationCreate(proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEducationCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.EducationFullInfo educationRead(proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEducationReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.EducationFullInfo> educationListRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getEducationListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.EducationFullInfo educationUpdateInfo(proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEducationUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue educationDelete(proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEducationDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EducationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EducationServiceFutureStub> {
    private EducationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.EducationFullInfo> educationCreate(
        proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEducationCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.EducationFullInfo> educationRead(
        proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEducationReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.EducationFullInfo> educationUpdateInfo(
        proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEducationUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> educationDelete(
        proto.ServerClient.EducationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEducationDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EDUCATION_CREATE = 0;
  private static final int METHODID_EDUCATION_READ = 1;
  private static final int METHODID_EDUCATION_LIST_READ = 2;
  private static final int METHODID_EDUCATION_UPDATE_INFO = 3;
  private static final int METHODID_EDUCATION_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EducationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EducationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EDUCATION_CREATE:
          serviceImpl.educationCreate((proto.ServerClient.EducationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo>) responseObserver);
          break;
        case METHODID_EDUCATION_READ:
          serviceImpl.educationRead((proto.ServerClient.EducationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo>) responseObserver);
          break;
        case METHODID_EDUCATION_LIST_READ:
          serviceImpl.educationListRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo>) responseObserver);
          break;
        case METHODID_EDUCATION_UPDATE_INFO:
          serviceImpl.educationUpdateInfo((proto.ServerClient.EducationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.EducationFullInfo>) responseObserver);
          break;
        case METHODID_EDUCATION_DELETE:
          serviceImpl.educationDelete((proto.ServerClient.EducationFullInfo) request,
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

  private static abstract class EducationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EducationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EducationService");
    }
  }

  private static final class EducationServiceFileDescriptorSupplier
      extends EducationServiceBaseDescriptorSupplier {
    EducationServiceFileDescriptorSupplier() {}
  }

  private static final class EducationServiceMethodDescriptorSupplier
      extends EducationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EducationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EducationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EducationServiceFileDescriptorSupplier())
              .addMethod(getEducationCreateMethod())
              .addMethod(getEducationReadMethod())
              .addMethod(getEducationListReadMethod())
              .addMethod(getEducationUpdateInfoMethod())
              .addMethod(getEducationDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
