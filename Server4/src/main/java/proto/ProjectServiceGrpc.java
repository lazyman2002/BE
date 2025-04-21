package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectServiceGrpc {

  private ProjectServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ProjectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectCreate",
      requestType = proto.ServerClient.ProjectFullInfo.class,
      responseType = proto.ServerClient.ProjectFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo> getProjectCreateMethod;
    if ((getProjectCreateMethod = ProjectServiceGrpc.getProjectCreateMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProjectCreateMethod = ProjectServiceGrpc.getProjectCreateMethod) == null) {
          ProjectServiceGrpc.getProjectCreateMethod = getProjectCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProjectCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("ProjectCreate"))
              .build();
        }
      }
    }
    return getProjectCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectRead",
      requestType = proto.ServerClient.ProjectFullInfo.class,
      responseType = proto.ServerClient.ProjectFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo> getProjectReadMethod;
    if ((getProjectReadMethod = ProjectServiceGrpc.getProjectReadMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProjectReadMethod = ProjectServiceGrpc.getProjectReadMethod) == null) {
          ProjectServiceGrpc.getProjectReadMethod = getProjectReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProjectRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("ProjectRead"))
              .build();
        }
      }
    }
    return getProjectReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectListRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.ProjectFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.ProjectFullInfo> getProjectListReadMethod;
    if ((getProjectListReadMethod = ProjectServiceGrpc.getProjectListReadMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProjectListReadMethod = ProjectServiceGrpc.getProjectListReadMethod) == null) {
          ProjectServiceGrpc.getProjectListReadMethod = getProjectListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.ProjectFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProjectListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("ProjectListRead"))
              .build();
        }
      }
    }
    return getProjectListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectUpdateInfo",
      requestType = proto.ServerClient.ProjectFullInfo.class,
      responseType = proto.ServerClient.ProjectFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      proto.ServerClient.ProjectFullInfo> getProjectUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo> getProjectUpdateInfoMethod;
    if ((getProjectUpdateInfoMethod = ProjectServiceGrpc.getProjectUpdateInfoMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProjectUpdateInfoMethod = ProjectServiceGrpc.getProjectUpdateInfoMethod) == null) {
          ProjectServiceGrpc.getProjectUpdateInfoMethod = getProjectUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.ProjectFullInfo, proto.ServerClient.ProjectFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProjectUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("ProjectUpdateInfo"))
              .build();
        }
      }
    }
    return getProjectUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      com.google.protobuf.BoolValue> getProjectDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectDelete",
      requestType = proto.ServerClient.ProjectFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo,
      com.google.protobuf.BoolValue> getProjectDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.ProjectFullInfo, com.google.protobuf.BoolValue> getProjectDeleteMethod;
    if ((getProjectDeleteMethod = ProjectServiceGrpc.getProjectDeleteMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProjectDeleteMethod = ProjectServiceGrpc.getProjectDeleteMethod) == null) {
          ProjectServiceGrpc.getProjectDeleteMethod = getProjectDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.ProjectFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProjectDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.ProjectFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("ProjectDelete"))
              .build();
        }
      }
    }
    return getProjectDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub>() {
        @java.lang.Override
        public ProjectServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectServiceStub(channel, callOptions);
        }
      };
    return ProjectServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub>() {
        @java.lang.Override
        public ProjectServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectServiceBlockingStub(channel, callOptions);
        }
      };
    return ProjectServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub>() {
        @java.lang.Override
        public ProjectServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectServiceFutureStub(channel, callOptions);
        }
      };
    return ProjectServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProjectServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void projectCreate(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProjectCreateMethod(), responseObserver);
    }

    /**
     */
    public void projectRead(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProjectReadMethod(), responseObserver);
    }

    /**
     */
    public void projectListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProjectListReadMethod(), responseObserver);
    }

    /**
     */
    public void projectUpdateInfo(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProjectUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void projectDelete(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProjectDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProjectCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.ProjectFullInfo,
                proto.ServerClient.ProjectFullInfo>(
                  this, METHODID_PROJECT_CREATE)))
          .addMethod(
            getProjectReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.ProjectFullInfo,
                proto.ServerClient.ProjectFullInfo>(
                  this, METHODID_PROJECT_READ)))
          .addMethod(
            getProjectListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.ProjectFullInfo>(
                  this, METHODID_PROJECT_LIST_READ)))
          .addMethod(
            getProjectUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.ProjectFullInfo,
                proto.ServerClient.ProjectFullInfo>(
                  this, METHODID_PROJECT_UPDATE_INFO)))
          .addMethod(
            getProjectDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.ProjectFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_PROJECT_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ProjectServiceStub extends io.grpc.stub.AbstractAsyncStub<ProjectServiceStub> {
    private ProjectServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceStub(channel, callOptions);
    }

    /**
     */
    public void projectCreate(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProjectCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void projectRead(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProjectReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void projectListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getProjectListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void projectUpdateInfo(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProjectUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void projectDelete(proto.ServerClient.ProjectFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProjectDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProjectServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProjectServiceBlockingStub> {
    private ProjectServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.ProjectFullInfo projectCreate(proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProjectCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.ProjectFullInfo projectRead(proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProjectReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.ProjectFullInfo> projectListRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getProjectListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.ProjectFullInfo projectUpdateInfo(proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProjectUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue projectDelete(proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProjectDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProjectServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProjectServiceFutureStub> {
    private ProjectServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.ProjectFullInfo> projectCreate(
        proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProjectCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.ProjectFullInfo> projectRead(
        proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProjectReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.ProjectFullInfo> projectUpdateInfo(
        proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProjectUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> projectDelete(
        proto.ServerClient.ProjectFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProjectDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROJECT_CREATE = 0;
  private static final int METHODID_PROJECT_READ = 1;
  private static final int METHODID_PROJECT_LIST_READ = 2;
  private static final int METHODID_PROJECT_UPDATE_INFO = 3;
  private static final int METHODID_PROJECT_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROJECT_CREATE:
          serviceImpl.projectCreate((proto.ServerClient.ProjectFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo>) responseObserver);
          break;
        case METHODID_PROJECT_READ:
          serviceImpl.projectRead((proto.ServerClient.ProjectFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo>) responseObserver);
          break;
        case METHODID_PROJECT_LIST_READ:
          serviceImpl.projectListRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo>) responseObserver);
          break;
        case METHODID_PROJECT_UPDATE_INFO:
          serviceImpl.projectUpdateInfo((proto.ServerClient.ProjectFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.ProjectFullInfo>) responseObserver);
          break;
        case METHODID_PROJECT_DELETE:
          serviceImpl.projectDelete((proto.ServerClient.ProjectFullInfo) request,
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

  private static abstract class ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectService");
    }
  }

  private static final class ProjectServiceFileDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier {
    ProjectServiceFileDescriptorSupplier() {}
  }

  private static final class ProjectServiceMethodDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProjectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectServiceFileDescriptorSupplier())
              .addMethod(getProjectCreateMethod())
              .addMethod(getProjectReadMethod())
              .addMethod(getProjectListReadMethod())
              .addMethod(getProjectUpdateInfoMethod())
              .addMethod(getProjectDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
