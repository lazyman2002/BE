package org.proto.source;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Server3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoleServiceGrpc {

  private RoleServiceGrpc() {}

  public static final String SERVICE_NAME = "org.proto.source.RoleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleRegister",
      requestType = org.proto.source.Server3.RoleFullInfo.class,
      responseType = org.proto.source.Server3.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleRegisterMethod() {
    io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo> getRoleRegisterMethod;
    if ((getRoleRegisterMethod = RoleServiceGrpc.getRoleRegisterMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleRegisterMethod = RoleServiceGrpc.getRoleRegisterMethod) == null) {
          RoleServiceGrpc.getRoleRegisterMethod = getRoleRegisterMethod =
              io.grpc.MethodDescriptor.<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleRegister"))
              .build();
        }
      }
    }
    return getRoleRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleReadInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleReadInfo",
      requestType = org.proto.source.Server3.RoleFullInfo.class,
      responseType = org.proto.source.Server3.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleReadInfoMethod() {
    io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo> getRoleReadInfoMethod;
    if ((getRoleReadInfoMethod = RoleServiceGrpc.getRoleReadInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleReadInfoMethod = RoleServiceGrpc.getRoleReadInfoMethod) == null) {
          RoleServiceGrpc.getRoleReadInfoMethod = getRoleReadInfoMethod =
              io.grpc.MethodDescriptor.<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleReadInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleReadInfo"))
              .build();
        }
      }
    }
    return getRoleReadInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleUpdateInfo",
      requestType = org.proto.source.Server3.RoleFullInfo.class,
      responseType = org.proto.source.Server3.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleUpdateInfoMethod() {
    io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo> getRoleUpdateInfoMethod;
    if ((getRoleUpdateInfoMethod = RoleServiceGrpc.getRoleUpdateInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleUpdateInfoMethod = RoleServiceGrpc.getRoleUpdateInfoMethod) == null) {
          RoleServiceGrpc.getRoleUpdateInfoMethod = getRoleUpdateInfoMethod =
              io.grpc.MethodDescriptor.<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RoleUpdateInfo"))
              .build();
        }
      }
    }
    return getRoleUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleDeleteInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoleDeleteInfo",
      requestType = org.proto.source.Server3.RoleFullInfo.class,
      responseType = org.proto.source.Server3.RoleFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo,
      org.proto.source.Server3.RoleFullInfo> getRoleDeleteInfoMethod() {
    io.grpc.MethodDescriptor<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo> getRoleDeleteInfoMethod;
    if ((getRoleDeleteInfoMethod = RoleServiceGrpc.getRoleDeleteInfoMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRoleDeleteInfoMethod = RoleServiceGrpc.getRoleDeleteInfoMethod) == null) {
          RoleServiceGrpc.getRoleDeleteInfoMethod = getRoleDeleteInfoMethod =
              io.grpc.MethodDescriptor.<org.proto.source.Server3.RoleFullInfo, org.proto.source.Server3.RoleFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RoleDeleteInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.proto.source.Server3.RoleFullInfo.getDefaultInstance()))
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
        @Override
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
        @Override
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
        @Override
        public RoleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceFutureStub(channel, callOptions);
        }
      };
    return RoleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RoleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void roleRegister(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleRegisterMethod(), responseObserver);
    }

    /**
     */
    public void roleReadInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleReadInfoMethod(), responseObserver);
    }

    /**
     */
    public void roleUpdateInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void roleDeleteInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoleDeleteInfoMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRoleRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.proto.source.Server3.RoleFullInfo,
                org.proto.source.Server3.RoleFullInfo>(
                  this, METHODID_ROLE_REGISTER)))
          .addMethod(
            getRoleReadInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.proto.source.Server3.RoleFullInfo,
                org.proto.source.Server3.RoleFullInfo>(
                  this, METHODID_ROLE_READ_INFO)))
          .addMethod(
            getRoleUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.proto.source.Server3.RoleFullInfo,
                org.proto.source.Server3.RoleFullInfo>(
                  this, METHODID_ROLE_UPDATE_INFO)))
          .addMethod(
            getRoleDeleteInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.proto.source.Server3.RoleFullInfo,
                org.proto.source.Server3.RoleFullInfo>(
                  this, METHODID_ROLE_DELETE_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class RoleServiceStub extends io.grpc.stub.AbstractAsyncStub<RoleServiceStub> {
    private RoleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RoleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceStub(channel, callOptions);
    }

    /**
     */
    public void roleRegister(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleReadInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleReadInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleUpdateInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void roleDeleteInfo(org.proto.source.Server3.RoleFullInfo request,
        io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoleDeleteInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RoleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RoleServiceBlockingStub> {
    private RoleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RoleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.proto.source.Server3.RoleFullInfo roleRegister(org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.proto.source.Server3.RoleFullInfo roleReadInfo(org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleReadInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.proto.source.Server3.RoleFullInfo roleUpdateInfo(org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.proto.source.Server3.RoleFullInfo roleDeleteInfo(org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoleDeleteInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RoleServiceFutureStub> {
    private RoleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RoleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.proto.source.Server3.RoleFullInfo> roleRegister(
        org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.proto.source.Server3.RoleFullInfo> roleReadInfo(
        org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleReadInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.proto.source.Server3.RoleFullInfo> roleUpdateInfo(
        org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.proto.source.Server3.RoleFullInfo> roleDeleteInfo(
        org.proto.source.Server3.RoleFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoleDeleteInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ROLE_REGISTER = 0;
  private static final int METHODID_ROLE_READ_INFO = 1;
  private static final int METHODID_ROLE_UPDATE_INFO = 2;
  private static final int METHODID_ROLE_DELETE_INFO = 3;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROLE_REGISTER:
          serviceImpl.roleRegister((org.proto.source.Server3.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_READ_INFO:
          serviceImpl.roleReadInfo((org.proto.source.Server3.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_UPDATE_INFO:
          serviceImpl.roleUpdateInfo((org.proto.source.Server3.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo>) responseObserver);
          break;
        case METHODID_ROLE_DELETE_INFO:
          serviceImpl.roleDeleteInfo((org.proto.source.Server3.RoleFullInfo) request,
              (io.grpc.stub.StreamObserver<org.proto.source.Server3.RoleFullInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
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

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.proto.source.Server3.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getRoleUpdateInfoMethod())
              .addMethod(getRoleDeleteInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
