package org.proto.source;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Server3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompanyServiceGrpc {

  private CompanyServiceGrpc() {}

  public static final String SERVICE_NAME = "org.proto.source.CompanyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Server3.CompanyFullInfo,
      Server3.CompanyFullInfo> getCompanyRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyRegister",
      requestType = Server3.CompanyFullInfo.class,
      responseType = Server3.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Server3.CompanyFullInfo,
      Server3.CompanyFullInfo> getCompanyRegisterMethod() {
    io.grpc.MethodDescriptor<Server3.CompanyFullInfo, Server3.CompanyFullInfo> getCompanyRegisterMethod;
    if ((getCompanyRegisterMethod = CompanyServiceGrpc.getCompanyRegisterMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyRegisterMethod = CompanyServiceGrpc.getCompanyRegisterMethod) == null) {
          CompanyServiceGrpc.getCompanyRegisterMethod = getCompanyRegisterMethod =
              io.grpc.MethodDescriptor.<Server3.CompanyFullInfo, Server3.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Server3.CompanyFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Server3.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyRegister"))
              .build();
        }
      }
    }
    return getCompanyRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Server3.CompanyFullInfo,
      Server3.CompanyFullInfo> getCompanyUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompanyUpdate",
      requestType = Server3.CompanyFullInfo.class,
      responseType = Server3.CompanyFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Server3.CompanyFullInfo,
      Server3.CompanyFullInfo> getCompanyUpdateMethod() {
    io.grpc.MethodDescriptor<Server3.CompanyFullInfo, Server3.CompanyFullInfo> getCompanyUpdateMethod;
    if ((getCompanyUpdateMethod = CompanyServiceGrpc.getCompanyUpdateMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCompanyUpdateMethod = CompanyServiceGrpc.getCompanyUpdateMethod) == null) {
          CompanyServiceGrpc.getCompanyUpdateMethod = getCompanyUpdateMethod =
              io.grpc.MethodDescriptor.<Server3.CompanyFullInfo, Server3.CompanyFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompanyUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Server3.CompanyFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Server3.CompanyFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("CompanyUpdate"))
              .build();
        }
      }
    }
    return getCompanyUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompanyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompanyServiceStub>() {
        @Override
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
        @Override
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
        @Override
        public CompanyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompanyServiceFutureStub(channel, callOptions);
        }
      };
    return CompanyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CompanyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void companyRegister(Server3.CompanyFullInfo request,
                                io.grpc.stub.StreamObserver<Server3.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyRegisterMethod(), responseObserver);
    }

    /**
     */
    public void companyUpdate(Server3.CompanyFullInfo request,
                              io.grpc.stub.StreamObserver<Server3.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCompanyUpdateMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCompanyRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Server3.CompanyFullInfo,
                Server3.CompanyFullInfo>(
                  this, METHODID_COMPANY_REGISTER)))
          .addMethod(
            getCompanyUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Server3.CompanyFullInfo,
                Server3.CompanyFullInfo>(
                  this, METHODID_COMPANY_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class CompanyServiceStub extends io.grpc.stub.AbstractAsyncStub<CompanyServiceStub> {
    private CompanyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CompanyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceStub(channel, callOptions);
    }

    /**
     */
    public void companyRegister(Server3.CompanyFullInfo request,
                                io.grpc.stub.StreamObserver<Server3.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void companyUpdate(Server3.CompanyFullInfo request,
                              io.grpc.stub.StreamObserver<Server3.CompanyFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompanyUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CompanyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CompanyServiceBlockingStub> {
    private CompanyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CompanyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Server3.CompanyFullInfo companyRegister(Server3.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public Server3.CompanyFullInfo companyUpdate(Server3.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompanyUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CompanyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CompanyServiceFutureStub> {
    private CompanyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CompanyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server3.CompanyFullInfo> companyRegister(
        Server3.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server3.CompanyFullInfo> companyUpdate(
        Server3.CompanyFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompanyUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPANY_REGISTER = 0;
  private static final int METHODID_COMPANY_UPDATE = 1;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPANY_REGISTER:
          serviceImpl.companyRegister((Server3.CompanyFullInfo) request,
              (io.grpc.stub.StreamObserver<Server3.CompanyFullInfo>) responseObserver);
          break;
        case METHODID_COMPANY_UPDATE:
          serviceImpl.companyUpdate((Server3.CompanyFullInfo) request,
              (io.grpc.stub.StreamObserver<Server3.CompanyFullInfo>) responseObserver);
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

  private static abstract class CompanyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompanyServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Server3.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getCompanyUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
