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
public final class LocationServiceGrpc {

  private LocationServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.LocationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo,
      proto.ServerClient.LocationFullInfo> getLocationRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationRegister",
      requestType = proto.ServerClient.LocationFullInfo.class,
      responseType = proto.ServerClient.LocationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo,
      proto.ServerClient.LocationFullInfo> getLocationRegisterMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo, proto.ServerClient.LocationFullInfo> getLocationRegisterMethod;
    if ((getLocationRegisterMethod = LocationServiceGrpc.getLocationRegisterMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getLocationRegisterMethod = LocationServiceGrpc.getLocationRegisterMethod) == null) {
          LocationServiceGrpc.getLocationRegisterMethod = getLocationRegisterMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.LocationFullInfo, proto.ServerClient.LocationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LocationRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("LocationRegister"))
              .build();
        }
      }
    }
    return getLocationRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo,
      proto.ServerClient.LocationFullInfo> getLocationReadInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationReadInfo",
      requestType = proto.ServerClient.LocationMetaInfo.class,
      responseType = proto.ServerClient.LocationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo,
      proto.ServerClient.LocationFullInfo> getLocationReadInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo, proto.ServerClient.LocationFullInfo> getLocationReadInfoMethod;
    if ((getLocationReadInfoMethod = LocationServiceGrpc.getLocationReadInfoMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getLocationReadInfoMethod = LocationServiceGrpc.getLocationReadInfoMethod) == null) {
          LocationServiceGrpc.getLocationReadInfoMethod = getLocationReadInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.LocationMetaInfo, proto.ServerClient.LocationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LocationReadInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("LocationReadInfo"))
              .build();
        }
      }
    }
    return getLocationReadInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.LocationFullInfo> getLocationListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.LocationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.LocationFullInfo> getLocationListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.LocationFullInfo> getLocationListReadMethod;
    if ((getLocationListReadMethod = LocationServiceGrpc.getLocationListReadMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getLocationListReadMethod = LocationServiceGrpc.getLocationListReadMethod) == null) {
          LocationServiceGrpc.getLocationListReadMethod = getLocationListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.LocationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LocationListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("LocationListRead"))
              .build();
        }
      }
    }
    return getLocationListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo,
      proto.ServerClient.LocationFullInfo> getLocationUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationUpdateInfo",
      requestType = proto.ServerClient.LocationFullInfo.class,
      responseType = proto.ServerClient.LocationFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo,
      proto.ServerClient.LocationFullInfo> getLocationUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.LocationFullInfo, proto.ServerClient.LocationFullInfo> getLocationUpdateInfoMethod;
    if ((getLocationUpdateInfoMethod = LocationServiceGrpc.getLocationUpdateInfoMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getLocationUpdateInfoMethod = LocationServiceGrpc.getLocationUpdateInfoMethod) == null) {
          LocationServiceGrpc.getLocationUpdateInfoMethod = getLocationUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.LocationFullInfo, proto.ServerClient.LocationFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LocationUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("LocationUpdateInfo"))
              .build();
        }
      }
    }
    return getLocationUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo,
      proto.ServerClient.Answer> getLocationDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationDelete",
      requestType = proto.ServerClient.LocationMetaInfo.class,
      responseType = proto.ServerClient.Answer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo,
      proto.ServerClient.Answer> getLocationDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.LocationMetaInfo, proto.ServerClient.Answer> getLocationDeleteMethod;
    if ((getLocationDeleteMethod = LocationServiceGrpc.getLocationDeleteMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getLocationDeleteMethod = LocationServiceGrpc.getLocationDeleteMethod) == null) {
          LocationServiceGrpc.getLocationDeleteMethod = getLocationDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.LocationMetaInfo, proto.ServerClient.Answer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LocationDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.LocationMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.Answer.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("LocationDelete"))
              .build();
        }
      }
    }
    return getLocationDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub>() {
        @java.lang.Override
        public LocationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceStub(channel, callOptions);
        }
      };
    return LocationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceBlockingStub>() {
        @java.lang.Override
        public LocationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceBlockingStub(channel, callOptions);
        }
      };
    return LocationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LocationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceFutureStub>() {
        @java.lang.Override
        public LocationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceFutureStub(channel, callOptions);
        }
      };
    return LocationServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static abstract class LocationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void locationRegister(proto.ServerClient.LocationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLocationRegisterMethod(), responseObserver);
    }

    /**
     */
    public void locationReadInfo(proto.ServerClient.LocationMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLocationReadInfoMethod(), responseObserver);
    }

    /**
     */
    public void locationListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLocationListReadMethod(), responseObserver);
    }

    /**
     */
    public void locationUpdateInfo(proto.ServerClient.LocationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLocationUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void locationDelete(proto.ServerClient.LocationMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.Answer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLocationDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLocationRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.LocationFullInfo,
                proto.ServerClient.LocationFullInfo>(
                  this, METHODID_LOCATION_REGISTER)))
          .addMethod(
            getLocationReadInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.LocationMetaInfo,
                proto.ServerClient.LocationFullInfo>(
                  this, METHODID_LOCATION_READ_INFO)))
          .addMethod(
            getLocationListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.LocationFullInfo>(
                  this, METHODID_LOCATION_LIST_READ)))
          .addMethod(
            getLocationUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.LocationFullInfo,
                proto.ServerClient.LocationFullInfo>(
                  this, METHODID_LOCATION_UPDATE_INFO)))
          .addMethod(
            getLocationDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.LocationMetaInfo,
                proto.ServerClient.Answer>(
                  this, METHODID_LOCATION_DELETE)))
          .build();
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class LocationServiceStub extends io.grpc.stub.AbstractAsyncStub<LocationServiceStub> {
    private LocationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceStub(channel, callOptions);
    }

    /**
     */
    public void locationRegister(proto.ServerClient.LocationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLocationRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void locationReadInfo(proto.ServerClient.LocationMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLocationReadInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void locationListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLocationListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void locationUpdateInfo(proto.ServerClient.LocationFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLocationUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void locationDelete(proto.ServerClient.LocationMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.Answer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLocationDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class LocationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LocationServiceBlockingStub> {
    private LocationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.LocationFullInfo locationRegister(proto.ServerClient.LocationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLocationRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.LocationFullInfo locationReadInfo(proto.ServerClient.LocationMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLocationReadInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.LocationFullInfo> locationListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLocationListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.LocationFullInfo locationUpdateInfo(proto.ServerClient.LocationFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLocationUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.Answer locationDelete(proto.ServerClient.LocationMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLocationDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class LocationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LocationServiceFutureStub> {
    private LocationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.LocationFullInfo> locationRegister(
        proto.ServerClient.LocationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLocationRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.LocationFullInfo> locationReadInfo(
        proto.ServerClient.LocationMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLocationReadInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.LocationFullInfo> locationUpdateInfo(
        proto.ServerClient.LocationFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLocationUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.Answer> locationDelete(
        proto.ServerClient.LocationMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLocationDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOCATION_REGISTER = 0;
  private static final int METHODID_LOCATION_READ_INFO = 1;
  private static final int METHODID_LOCATION_LIST_READ = 2;
  private static final int METHODID_LOCATION_UPDATE_INFO = 3;
  private static final int METHODID_LOCATION_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LocationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LocationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOCATION_REGISTER:
          serviceImpl.locationRegister((proto.ServerClient.LocationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo>) responseObserver);
          break;
        case METHODID_LOCATION_READ_INFO:
          serviceImpl.locationReadInfo((proto.ServerClient.LocationMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo>) responseObserver);
          break;
        case METHODID_LOCATION_LIST_READ:
          serviceImpl.locationListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo>) responseObserver);
          break;
        case METHODID_LOCATION_UPDATE_INFO:
          serviceImpl.locationUpdateInfo((proto.ServerClient.LocationFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.LocationFullInfo>) responseObserver);
          break;
        case METHODID_LOCATION_DELETE:
          serviceImpl.locationDelete((proto.ServerClient.LocationMetaInfo) request,
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

  private static abstract class LocationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LocationService");
    }
  }

  private static final class LocationServiceFileDescriptorSupplier
      extends LocationServiceBaseDescriptorSupplier {
    LocationServiceFileDescriptorSupplier() {}
  }

  private static final class LocationServiceMethodDescriptorSupplier
      extends LocationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LocationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LocationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LocationServiceFileDescriptorSupplier())
              .addMethod(getLocationRegisterMethod())
              .addMethod(getLocationReadInfoMethod())
              .addMethod(getLocationListReadMethod())
              .addMethod(getLocationUpdateInfoMethod())
              .addMethod(getLocationDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
