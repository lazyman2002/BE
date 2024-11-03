package org.proto;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Server3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LocationServiceGrpc {

  private LocationServiceGrpc() {}

  public static final String SERVICE_NAME = "org.proto.LocationService";

  // Static method descriptors that strictly reflect the proto.
  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub>() {
        @Override
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
        @Override
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
        @Override
        public LocationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceFutureStub(channel, callOptions);
        }
      };
    return LocationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LocationServiceImplBase implements io.grpc.BindableService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .build();
    }
  }

  /**
   */
  public static final class LocationServiceStub extends io.grpc.stub.AbstractAsyncStub<LocationServiceStub> {
    private LocationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LocationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class LocationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LocationServiceBlockingStub> {
    private LocationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LocationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class LocationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LocationServiceFutureStub> {
    private LocationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LocationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceFutureStub(channel, callOptions);
    }
  }


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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static abstract class LocationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Server3.getDescriptor();
    }

    @Override
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

    @Override
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
              .build();
        }
      }
    }
    return result;
  }
}
