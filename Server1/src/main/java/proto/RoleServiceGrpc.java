package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *OK
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoleServiceGrpc {

  private RoleServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.RoleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleRegister",
      requestType = proto.ServerClient.RoleFullInfo.class,
      responseType = proto.ServerClient.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleRegisterMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo> getRoleRegisterMethod;
    if ((getRoleRegisterMethod = RoleServiceGrpc.getRoleRegisterMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleRegisterMethod = RoleServiceGrpc.getRoleRegisterMethod) == null) {
          RoleServiceGrpc.getRoleRegisterMethod = getRoleRegisterMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleRegister"))
              .build();
        }
      }
    }
    return getRoleRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleReadInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleReadInfo",
      requestType = proto.ServerClient.RoleFullInfo.class,
      responseType = proto.ServerClient.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleReadInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo> getRoleReadInfoMethod;
    if ((getRoleReadInfoMethod = RoleServiceGrpc.getRoleReadInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleReadInfoMethod = RoleServiceGrpc.getRoleReadInfoMethod) == null) {
          RoleServiceGrpc.getRoleReadInfoMethod = getRoleReadInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleReadInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleReadInfo"))
              .build();
        }
      }
    }
    return getRoleReadInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      proto.ServerClient.RoleFullInfo> getRoleListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleListRead",
      requestType = proto.ServerClient.CompanyMetaInfo.class,
      responseType = proto.ServerClient.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      proto.ServerClient.RoleFullInfo> getRoleListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo, proto.ServerClient.RoleFullInfo> getRoleListReadMethod;
    if ((getRoleListReadMethod = RoleServiceGrpc.getRoleListReadMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleListReadMethod = RoleServiceGrpc.getRoleListReadMethod) == null) {
          RoleServiceGrpc.getRoleListReadMethod = getRoleListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CompanyMetaInfo, proto.ServerClient.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleListRead"))
              .build();
        }
      }
    }
    return getRoleListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleUpdateInfo",
      requestType = proto.ServerClient.RoleFullInfo.class,
      responseType = proto.ServerClient.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.RoleFullInfo> getRoleUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo> getRoleUpdateInfoMethod;
    if ((getRoleUpdateInfoMethod = RoleServiceGrpc.getRoleUpdateInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleUpdateInfoMethod = RoleServiceGrpc.getRoleUpdateInfoMethod) == null) {
          RoleServiceGrpc.getRoleUpdateInfoMethod = getRoleUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RoleFullInfo, proto.ServerClient.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleUpdateInfo"))
              .build();
        }
      }
    }
    return getRoleUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.Answer> getRoleDeleteInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleDeleteInfo",
      requestType = proto.ServerClient.RoleFullInfo.class,
      responseType = proto.ServerClient.Answer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo,
      proto.ServerClient.Answer> getRoleDeleteInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RoleFullInfo, proto.ServerClient.Answer> getRoleDeleteInfoMethod;
    if ((getRoleDeleteInfoMethod = RoleServiceGrpc.getRoleDeleteInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleDeleteInfoMethod = RoleServiceGrpc.getRoleDeleteInfoMethod) == null) {
          RoleServiceGrpc.getRoleDeleteInfoMethod = getRoleDeleteInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RoleFullInfo, proto.ServerClient.Answer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleDeleteInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.Answer.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleDeleteInfo"))
              .build();
        }
      }
    }
    return getRoleDeleteInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceStub>() {
        @java.lang.Override
        public RoleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceStub(channel, callOptions);
        }
      };
    return RoleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingStub>() {
        @java.lang.Override
        public RoleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceBlockingStub(channel, callOptions);
        }
      };
    return RoleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceFutureStub>() {
        @java.lang.Override
        public RoleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceFutureStub(channel, callOptions);
        }
      };
    return RoleServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static abstract class RoleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void roleRegister(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleRegisterMethod(), responseObserver);
    }

    /**
     */
    public void roleReadInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleReadInfoMethod(), responseObserver);
    }

    /**
     */
    public void roleListRead(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleListReadMethod(), responseObserver);
    }

    /**
     */
    public void roleUpdateInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void roleDeleteInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.Answer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleDeleteInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRoleRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RoleFullInfo,
                proto.ServerClient.RoleFullInfo>(
                  this, METHODID_ROLE_REGISTER)))
          .addMethod(
            getRoleReadInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RoleFullInfo,
                proto.ServerClient.RoleFullInfo>(
                  this, METHODID_ROLE_READ_INFO)))
          .addMethod(
            getRoleListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CompanyMetaInfo,
                proto.ServerClient.RoleFullInfo>(
                  this, METHODID_ROLE_LIST_READ)))
          .addMethod(
            getRoleUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RoleFullInfo,
                proto.ServerClient.RoleFullInfo>(
                  this, METHODID_ROLE_UPDATE_INFO)))
          .addMethod(
            getRoleDeleteInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RoleFullInfo,
                proto.ServerClient.Answer>(
                  this, METHODID_ROLE_DELETE_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class RoleServiceStub extends io.grpc.stub.AbstractAsyncStub<RoleServiceStub> {
    private RoleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceStub(channel, callOptions);
    }

    /**
     */
    public void roleRegister(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleReadInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleReadInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleListRead(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRoleListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleUpdateInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleDeleteInfo(proto.ServerClient.RoleFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.Answer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleDeleteInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class RoleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RoleServiceBlockingStub> {
    private RoleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.RoleFullInfo roleRegister(proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.RoleFullInfo roleReadInfo(proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleReadInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.RoleFullInfo> roleListRead(
        proto.ServerClient.CompanyMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRoleListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.RoleFullInfo roleUpdateInfo(proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.Answer roleDeleteInfo(proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleDeleteInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class RoleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RoleServiceFutureStub> {
    private RoleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RoleFullInfo> roleRegister(
        proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RoleFullInfo> roleReadInfo(
        proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleReadInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RoleFullInfo> roleUpdateInfo(
        proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.Answer> roleDeleteInfo(
        proto.ServerClient.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleDeleteInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ROLE_REGISTER = 0;
  private static final int METHODID_ROLE_READ_INFO = 1;
  private static final int METHODID_ROLE_LIST_READ = 2;
  private static final int METHODID_ROLE_UPDATE_INFO = 3;
  private static final int METHODID_ROLE_DELETE_INFO = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROLE_REGISTER:
          serviceImpl.roleRegister((proto.ServerClient.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_READ_INFO:
          serviceImpl.roleReadInfo((proto.ServerClient.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_LIST_READ:
          serviceImpl.roleListRead((proto.ServerClient.CompanyMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_UPDATE_INFO:
          serviceImpl.roleUpdateInfo((proto.ServerClient.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_DELETE_INFO:
          serviceImpl.roleDeleteInfo((proto.ServerClient.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.Answer>) responseObserver);
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

  private static abstract class RoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoleService");
    }
  }

  private static final class RoleServiceFileDescriptorSupplier
      extends RoleServiceBaseDescriptorSupplier {
    RoleServiceFileDescriptorSupplier() {}
  }

  private static final class RoleServiceMethodDescriptorSupplier
      extends RoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoleServiceFileDescriptorSupplier())
              .addMethod(getRoleRegisterMethod())
              .addMethod(getRoleReadInfoMethod())
              .addMethod(getRoleListReadMethod())
              .addMethod(getRoleUpdateInfoMethod())
              .addMethod(getRoleDeleteInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
