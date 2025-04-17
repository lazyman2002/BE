package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerClient.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PersonalityServiceGrpc {

  private PersonalityServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.PersonalityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PersonalityCreate",
      requestType = proto.ServerClient.PersonalityFullInfo.class,
      responseType = proto.ServerClient.PersonalityFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo> getPersonalityCreateMethod;
    if ((getPersonalityCreateMethod = PersonalityServiceGrpc.getPersonalityCreateMethod) == null) {
      synchronized (PersonalityServiceGrpc.class) {
        if ((getPersonalityCreateMethod = PersonalityServiceGrpc.getPersonalityCreateMethod) == null) {
          PersonalityServiceGrpc.getPersonalityCreateMethod = getPersonalityCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PersonalityCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new PersonalityServiceMethodDescriptorSupplier("PersonalityCreate"))
              .build();
        }
      }
    }
    return getPersonalityCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PersonalityRead",
      requestType = proto.ServerClient.PersonalityFullInfo.class,
      responseType = proto.ServerClient.PersonalityFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo> getPersonalityReadMethod;
    if ((getPersonalityReadMethod = PersonalityServiceGrpc.getPersonalityReadMethod) == null) {
      synchronized (PersonalityServiceGrpc.class) {
        if ((getPersonalityReadMethod = PersonalityServiceGrpc.getPersonalityReadMethod) == null) {
          PersonalityServiceGrpc.getPersonalityReadMethod = getPersonalityReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PersonalityRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new PersonalityServiceMethodDescriptorSupplier("PersonalityRead"))
              .build();
        }
      }
    }
    return getPersonalityReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PersonalityListRead",
      requestType = proto.ServerClient.CVFullInfo.class,
      responseType = proto.ServerClient.PersonalityFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CVFullInfo, proto.ServerClient.PersonalityFullInfo> getPersonalityListReadMethod;
    if ((getPersonalityListReadMethod = PersonalityServiceGrpc.getPersonalityListReadMethod) == null) {
      synchronized (PersonalityServiceGrpc.class) {
        if ((getPersonalityListReadMethod = PersonalityServiceGrpc.getPersonalityListReadMethod) == null) {
          PersonalityServiceGrpc.getPersonalityListReadMethod = getPersonalityListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CVFullInfo, proto.ServerClient.PersonalityFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PersonalityListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CVFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new PersonalityServiceMethodDescriptorSupplier("PersonalityListRead"))
              .build();
        }
      }
    }
    return getPersonalityListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PersonalityUpdateInfo",
      requestType = proto.ServerClient.PersonalityFullInfo.class,
      responseType = proto.ServerClient.PersonalityFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      proto.ServerClient.PersonalityFullInfo> getPersonalityUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo> getPersonalityUpdateInfoMethod;
    if ((getPersonalityUpdateInfoMethod = PersonalityServiceGrpc.getPersonalityUpdateInfoMethod) == null) {
      synchronized (PersonalityServiceGrpc.class) {
        if ((getPersonalityUpdateInfoMethod = PersonalityServiceGrpc.getPersonalityUpdateInfoMethod) == null) {
          PersonalityServiceGrpc.getPersonalityUpdateInfoMethod = getPersonalityUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.PersonalityFullInfo, proto.ServerClient.PersonalityFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PersonalityUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new PersonalityServiceMethodDescriptorSupplier("PersonalityUpdateInfo"))
              .build();
        }
      }
    }
    return getPersonalityUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      com.google.protobuf.BoolValue> getPersonalityDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PersonalityDelete",
      requestType = proto.ServerClient.PersonalityFullInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo,
      com.google.protobuf.BoolValue> getPersonalityDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.PersonalityFullInfo, com.google.protobuf.BoolValue> getPersonalityDeleteMethod;
    if ((getPersonalityDeleteMethod = PersonalityServiceGrpc.getPersonalityDeleteMethod) == null) {
      synchronized (PersonalityServiceGrpc.class) {
        if ((getPersonalityDeleteMethod = PersonalityServiceGrpc.getPersonalityDeleteMethod) == null) {
          PersonalityServiceGrpc.getPersonalityDeleteMethod = getPersonalityDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.PersonalityFullInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PersonalityDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.PersonalityFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PersonalityServiceMethodDescriptorSupplier("PersonalityDelete"))
              .build();
        }
      }
    }
    return getPersonalityDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonalityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceStub>() {
        @java.lang.Override
        public PersonalityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonalityServiceStub(channel, callOptions);
        }
      };
    return PersonalityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonalityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceBlockingStub>() {
        @java.lang.Override
        public PersonalityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonalityServiceBlockingStub(channel, callOptions);
        }
      };
    return PersonalityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonalityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonalityServiceFutureStub>() {
        @java.lang.Override
        public PersonalityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonalityServiceFutureStub(channel, callOptions);
        }
      };
    return PersonalityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PersonalityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void personalityCreate(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPersonalityCreateMethod(), responseObserver);
    }

    /**
     */
    public void personalityRead(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPersonalityReadMethod(), responseObserver);
    }

    /**
     */
    public void personalityListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPersonalityListReadMethod(), responseObserver);
    }

    /**
     */
    public void personalityUpdateInfo(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPersonalityUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void personalityDelete(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPersonalityDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPersonalityCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.PersonalityFullInfo,
                proto.ServerClient.PersonalityFullInfo>(
                  this, METHODID_PERSONALITY_CREATE)))
          .addMethod(
            getPersonalityReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.PersonalityFullInfo,
                proto.ServerClient.PersonalityFullInfo>(
                  this, METHODID_PERSONALITY_READ)))
          .addMethod(
            getPersonalityListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerClient.CVFullInfo,
                proto.ServerClient.PersonalityFullInfo>(
                  this, METHODID_PERSONALITY_LIST_READ)))
          .addMethod(
            getPersonalityUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.PersonalityFullInfo,
                proto.ServerClient.PersonalityFullInfo>(
                  this, METHODID_PERSONALITY_UPDATE_INFO)))
          .addMethod(
            getPersonalityDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.PersonalityFullInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_PERSONALITY_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class PersonalityServiceStub extends io.grpc.stub.AbstractAsyncStub<PersonalityServiceStub> {
    private PersonalityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonalityServiceStub(channel, callOptions);
    }

    /**
     */
    public void personalityCreate(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPersonalityCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void personalityRead(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPersonalityReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void personalityListRead(proto.ServerClient.CVFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getPersonalityListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void personalityUpdateInfo(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPersonalityUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void personalityDelete(proto.ServerClient.PersonalityFullInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPersonalityDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PersonalityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PersonalityServiceBlockingStub> {
    private PersonalityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonalityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.PersonalityFullInfo personalityCreate(proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPersonalityCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.PersonalityFullInfo personalityRead(proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPersonalityReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.PersonalityFullInfo> personalityListRead(
        proto.ServerClient.CVFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getPersonalityListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.PersonalityFullInfo personalityUpdateInfo(proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPersonalityUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue personalityDelete(proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPersonalityDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonalityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PersonalityServiceFutureStub> {
    private PersonalityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonalityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.PersonalityFullInfo> personalityCreate(
        proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPersonalityCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.PersonalityFullInfo> personalityRead(
        proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPersonalityReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.PersonalityFullInfo> personalityUpdateInfo(
        proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPersonalityUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> personalityDelete(
        proto.ServerClient.PersonalityFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPersonalityDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PERSONALITY_CREATE = 0;
  private static final int METHODID_PERSONALITY_READ = 1;
  private static final int METHODID_PERSONALITY_LIST_READ = 2;
  private static final int METHODID_PERSONALITY_UPDATE_INFO = 3;
  private static final int METHODID_PERSONALITY_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonalityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonalityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PERSONALITY_CREATE:
          serviceImpl.personalityCreate((proto.ServerClient.PersonalityFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo>) responseObserver);
          break;
        case METHODID_PERSONALITY_READ:
          serviceImpl.personalityRead((proto.ServerClient.PersonalityFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo>) responseObserver);
          break;
        case METHODID_PERSONALITY_LIST_READ:
          serviceImpl.personalityListRead((proto.ServerClient.CVFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo>) responseObserver);
          break;
        case METHODID_PERSONALITY_UPDATE_INFO:
          serviceImpl.personalityUpdateInfo((proto.ServerClient.PersonalityFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.PersonalityFullInfo>) responseObserver);
          break;
        case METHODID_PERSONALITY_DELETE:
          serviceImpl.personalityDelete((proto.ServerClient.PersonalityFullInfo) request,
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

  private static abstract class PersonalityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonalityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonalityService");
    }
  }

  private static final class PersonalityServiceFileDescriptorSupplier
      extends PersonalityServiceBaseDescriptorSupplier {
    PersonalityServiceFileDescriptorSupplier() {}
  }

  private static final class PersonalityServiceMethodDescriptorSupplier
      extends PersonalityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonalityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PersonalityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonalityServiceFileDescriptorSupplier())
              .addMethod(getPersonalityCreateMethod())
              .addMethod(getPersonalityReadMethod())
              .addMethod(getPersonalityListReadMethod())
              .addMethod(getPersonalityUpdateInfoMethod())
              .addMethod(getPersonalityDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
