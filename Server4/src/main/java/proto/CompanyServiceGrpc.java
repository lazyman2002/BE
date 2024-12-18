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
public final class CompanyServiceGrpc {

  private CompanyServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CompanyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyRegister",
      requestType = proto.ServerClient.CompanyFullInfo.class,
      responseType = proto.ServerClient.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyRegisterMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo, proto.ServerClient.CompanyFullInfo> getCompanyRegisterMethod;
    if ((getCompanyRegisterMethod = CompanyServiceGrpc.getCompanyRegisterMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyRegisterMethod = CompanyServiceGrpc.getCompanyRegisterMethod) == null) {
          CompanyServiceGrpc.getCompanyRegisterMethod = getCompanyRegisterMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CompanyFullInfo, proto.ServerClient.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyRegister"))
              .build();
        }
      }
    }
    return getCompanyRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyReadInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyReadInfo",
      requestType = proto.ServerClient.CompanyMetaInfo.class,
      responseType = proto.ServerClient.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyReadInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo, proto.ServerClient.CompanyFullInfo> getCompanyReadInfoMethod;
    if ((getCompanyReadInfoMethod = CompanyServiceGrpc.getCompanyReadInfoMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyReadInfoMethod = CompanyServiceGrpc.getCompanyReadInfoMethod) == null) {
          CompanyServiceGrpc.getCompanyReadInfoMethod = getCompanyReadInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CompanyMetaInfo, proto.ServerClient.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyReadInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyReadInfo"))
              .build();
        }
      }
    }
    return getCompanyReadInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.CompanyFullInfo> getCompanyListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.CompanyFullInfo> getCompanyListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.CompanyFullInfo> getCompanyListReadMethod;
    if ((getCompanyListReadMethod = CompanyServiceGrpc.getCompanyListReadMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyListReadMethod = CompanyServiceGrpc.getCompanyListReadMethod) == null) {
          CompanyServiceGrpc.getCompanyListReadMethod = getCompanyListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyListRead"))
              .build();
        }
      }
    }
    return getCompanyListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyUpdateInfo",
      requestType = proto.ServerClient.CompanyFullInfo.class,
      responseType = proto.ServerClient.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo,
      proto.ServerClient.CompanyFullInfo> getCompanyUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CompanyFullInfo, proto.ServerClient.CompanyFullInfo> getCompanyUpdateInfoMethod;
    if ((getCompanyUpdateInfoMethod = CompanyServiceGrpc.getCompanyUpdateInfoMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyUpdateInfoMethod = CompanyServiceGrpc.getCompanyUpdateInfoMethod) == null) {
          CompanyServiceGrpc.getCompanyUpdateInfoMethod = getCompanyUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CompanyFullInfo, proto.ServerClient.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyUpdateInfo"))
              .build();
        }
      }
    }
    return getCompanyUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      com.google.protobuf.BoolValue> getCompanyDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyDelete",
      requestType = proto.ServerClient.CompanyMetaInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo,
      com.google.protobuf.BoolValue> getCompanyDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CompanyMetaInfo, com.google.protobuf.BoolValue> getCompanyDeleteMethod;
    if ((getCompanyDeleteMethod = CompanyServiceGrpc.getCompanyDeleteMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyDeleteMethod = CompanyServiceGrpc.getCompanyDeleteMethod) == null) {
          CompanyServiceGrpc.getCompanyDeleteMethod = getCompanyDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CompanyMetaInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CompanyMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyDelete"))
              .build();
        }
      }
    }
    return getCompanyDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompanyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompanyServiceStub>() {
        @java.lang.Override
        public CompanyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompanyServiceStub(channel, callOptions);
        }
      };
    return CompanyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompanyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompanyServiceBlockingStub>() {
        @java.lang.Override
        public CompanyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompanyServiceBlockingStub(channel, callOptions);
        }
      };
    return CompanyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CompanyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompanyServiceFutureStub>() {
        @java.lang.Override
        public CompanyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompanyServiceFutureStub(channel, callOptions);
        }
      };
    return CompanyServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static abstract class CompanyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void companyRegister(proto.ServerClient.CompanyFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyRegisterMethod(), responseObserver);
    }

    /**
     */
    public void companyReadInfo(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyReadInfoMethod(), responseObserver);
    }

    /**
     */
    public void companyListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyListReadMethod(), responseObserver);
    }

    /**
     */
    public void companyUpdateInfo(proto.ServerClient.CompanyFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void companyDelete(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCompanyRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CompanyFullInfo,
                proto.ServerClient.CompanyFullInfo>(
                  this, METHODID_COMPANY_REGISTER)))
          .addMethod(
            getCompanyReadInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CompanyMetaInfo,
                proto.ServerClient.CompanyFullInfo>(
                  this, METHODID_COMPANY_READ_INFO)))
          .addMethod(
            getCompanyListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.CompanyFullInfo>(
                  this, METHODID_COMPANY_LIST_READ)))
          .addMethod(
            getCompanyUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CompanyFullInfo,
                proto.ServerClient.CompanyFullInfo>(
                  this, METHODID_COMPANY_UPDATE_INFO)))
          .addMethod(
            getCompanyDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CompanyMetaInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_COMPANY_DELETE)))
          .build();
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class CompanyServiceStub extends io.grpc.stub.AbstractAsyncStub<CompanyServiceStub> {
    private CompanyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceStub(channel, callOptions);
    }

    /**
     */
    public void companyRegister(proto.ServerClient.CompanyFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void companyReadInfo(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyReadInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void companyListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCompanyListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void companyUpdateInfo(proto.ServerClient.CompanyFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void companyDelete(proto.ServerClient.CompanyMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class CompanyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CompanyServiceBlockingStub> {
    private CompanyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.CompanyFullInfo companyRegister(proto.ServerClient.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CompanyFullInfo companyReadInfo(proto.ServerClient.CompanyMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyReadInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CompanyFullInfo> companyListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCompanyListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CompanyFullInfo companyUpdateInfo(proto.ServerClient.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue companyDelete(proto.ServerClient.CompanyMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class CompanyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CompanyServiceFutureStub> {
    private CompanyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CompanyFullInfo> companyRegister(
        proto.ServerClient.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CompanyFullInfo> companyReadInfo(
        proto.ServerClient.CompanyMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyReadInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CompanyFullInfo> companyUpdateInfo(
        proto.ServerClient.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> companyDelete(
        proto.ServerClient.CompanyMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPANY_REGISTER = 0;
  private static final int METHODID_COMPANY_READ_INFO = 1;
  private static final int METHODID_COMPANY_LIST_READ = 2;
  private static final int METHODID_COMPANY_UPDATE_INFO = 3;
  private static final int METHODID_COMPANY_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompanyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompanyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPANY_REGISTER:
          serviceImpl.companyRegister((proto.ServerClient.CompanyFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_COMPANY_READ_INFO:
          serviceImpl.companyReadInfo((proto.ServerClient.CompanyMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_COMPANY_LIST_READ:
          serviceImpl.companyListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_COMPANY_UPDATE_INFO:
          serviceImpl.companyUpdateInfo((proto.ServerClient.CompanyFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_COMPANY_DELETE:
          serviceImpl.companyDelete((proto.ServerClient.CompanyMetaInfo) request,
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

  private static abstract class CompanyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompanyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompanyService");
    }
  }

  private static final class CompanyServiceFileDescriptorSupplier
      extends CompanyServiceBaseDescriptorSupplier {
    CompanyServiceFileDescriptorSupplier() {}
  }

  private static final class CompanyServiceMethodDescriptorSupplier
      extends CompanyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompanyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompanyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CompanyServiceFileDescriptorSupplier())
              .addMethod(getCompanyRegisterMethod())
              .addMethod(getCompanyReadInfoMethod())
              .addMethod(getCompanyListReadMethod())
              .addMethod(getCompanyUpdateInfoMethod())
              .addMethod(getCompanyDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
