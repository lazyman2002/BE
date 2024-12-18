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
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CandidateCreate",
      requestType = proto.ServerClient.CandidateFullInfo.class,
      responseType = proto.ServerClient.CandidateFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo, proto.ServerClient.CandidateFullInfo> getCandidateCreateMethod;
    if ((getCandidateCreateMethod = UserServiceGrpc.getCandidateCreateMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCandidateCreateMethod = UserServiceGrpc.getCandidateCreateMethod) == null) {
          UserServiceGrpc.getCandidateCreateMethod = getCandidateCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CandidateFullInfo, proto.ServerClient.CandidateFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CandidateCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CandidateCreate"))
              .build();
        }
      }
    }
    return getCandidateCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecruiterCreate",
      requestType = proto.ServerClient.RecruiterFullInfo.class,
      responseType = proto.ServerClient.RecruiterFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo, proto.ServerClient.RecruiterFullInfo> getRecruiterCreateMethod;
    if ((getRecruiterCreateMethod = UserServiceGrpc.getRecruiterCreateMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRecruiterCreateMethod = UserServiceGrpc.getRecruiterCreateMethod) == null) {
          UserServiceGrpc.getRecruiterCreateMethod = getRecruiterCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RecruiterFullInfo, proto.ServerClient.RecruiterFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecruiterCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("RecruiterCreate"))
              .build();
        }
      }
    }
    return getRecruiterCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.UserFullInfo> getUserReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserRead",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = proto.ServerClient.UserFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.UserFullInfo> getUserReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, proto.ServerClient.UserFullInfo> getUserReadMethod;
    if ((getUserReadMethod = UserServiceGrpc.getUserReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUserReadMethod = UserServiceGrpc.getUserReadMethod) == null) {
          UserServiceGrpc.getUserReadMethod = getUserReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, proto.ServerClient.UserFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UserRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UserRead"))
              .build();
        }
      }
    }
    return getUserReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.UserMetaInfo> getUserListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.UserMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.UserMetaInfo> getUserListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.UserMetaInfo> getUserListReadMethod;
    if ((getUserListReadMethod = UserServiceGrpc.getUserListReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUserListReadMethod = UserServiceGrpc.getUserListReadMethod) == null) {
          UserServiceGrpc.getUserListReadMethod = getUserListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.UserMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UserListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UserListRead"))
              .build();
        }
      }
    }
    return getUserListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CandidateRead",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = proto.ServerClient.CandidateFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, proto.ServerClient.CandidateFullInfo> getCandidateReadMethod;
    if ((getCandidateReadMethod = UserServiceGrpc.getCandidateReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCandidateReadMethod = UserServiceGrpc.getCandidateReadMethod) == null) {
          UserServiceGrpc.getCandidateReadMethod = getCandidateReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, proto.ServerClient.CandidateFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CandidateRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CandidateRead"))
              .build();
        }
      }
    }
    return getCandidateReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.CandidateFullInfo> getCandidateListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CandidateListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.CandidateFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.CandidateFullInfo> getCandidateListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.CandidateFullInfo> getCandidateListReadMethod;
    if ((getCandidateListReadMethod = UserServiceGrpc.getCandidateListReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCandidateListReadMethod = UserServiceGrpc.getCandidateListReadMethod) == null) {
          UserServiceGrpc.getCandidateListReadMethod = getCandidateListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.CandidateFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CandidateListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CandidateListRead"))
              .build();
        }
      }
    }
    return getCandidateListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecruiterRead",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = proto.ServerClient.RecruiterFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, proto.ServerClient.RecruiterFullInfo> getRecruiterReadMethod;
    if ((getRecruiterReadMethod = UserServiceGrpc.getRecruiterReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRecruiterReadMethod = UserServiceGrpc.getRecruiterReadMethod) == null) {
          UserServiceGrpc.getRecruiterReadMethod = getRecruiterReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, proto.ServerClient.RecruiterFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecruiterRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("RecruiterRead"))
              .build();
        }
      }
    }
    return getRecruiterReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.RecruiterFullInfo> getRecruiterListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecruiterListRead",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.ServerClient.RecruiterFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.ServerClient.RecruiterFullInfo> getRecruiterListReadMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.ServerClient.RecruiterFullInfo> getRecruiterListReadMethod;
    if ((getRecruiterListReadMethod = UserServiceGrpc.getRecruiterListReadMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRecruiterListReadMethod = UserServiceGrpc.getRecruiterListReadMethod) == null) {
          UserServiceGrpc.getRecruiterListReadMethod = getRecruiterListReadMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.ServerClient.RecruiterFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecruiterListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("RecruiterListRead"))
              .build();
        }
      }
    }
    return getRecruiterListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.UserFullInfo> getUserUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserUpdate",
      requestType = proto.ServerClient.UserFullInfo.class,
      responseType = proto.ServerClient.UserFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo,
      proto.ServerClient.UserFullInfo> getUserUpdateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserFullInfo, proto.ServerClient.UserFullInfo> getUserUpdateMethod;
    if ((getUserUpdateMethod = UserServiceGrpc.getUserUpdateMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUserUpdateMethod = UserServiceGrpc.getUserUpdateMethod) == null) {
          UserServiceGrpc.getUserUpdateMethod = getUserUpdateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserFullInfo, proto.ServerClient.UserFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UserUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UserUpdate"))
              .build();
        }
      }
    }
    return getUserUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CandidateUpdate",
      requestType = proto.ServerClient.CandidateFullInfo.class,
      responseType = proto.ServerClient.CandidateFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo,
      proto.ServerClient.CandidateFullInfo> getCandidateUpdateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.CandidateFullInfo, proto.ServerClient.CandidateFullInfo> getCandidateUpdateMethod;
    if ((getCandidateUpdateMethod = UserServiceGrpc.getCandidateUpdateMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCandidateUpdateMethod = UserServiceGrpc.getCandidateUpdateMethod) == null) {
          UserServiceGrpc.getCandidateUpdateMethod = getCandidateUpdateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.CandidateFullInfo, proto.ServerClient.CandidateFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CandidateUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.CandidateFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CandidateUpdate"))
              .build();
        }
      }
    }
    return getCandidateUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecruiterUpdate",
      requestType = proto.ServerClient.RecruiterFullInfo.class,
      responseType = proto.ServerClient.RecruiterFullInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo,
      proto.ServerClient.RecruiterFullInfo> getRecruiterUpdateMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.RecruiterFullInfo, proto.ServerClient.RecruiterFullInfo> getRecruiterUpdateMethod;
    if ((getRecruiterUpdateMethod = UserServiceGrpc.getRecruiterUpdateMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRecruiterUpdateMethod = UserServiceGrpc.getRecruiterUpdateMethod) == null) {
          UserServiceGrpc.getRecruiterUpdateMethod = getRecruiterUpdateMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.RecruiterFullInfo, proto.ServerClient.RecruiterFullInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecruiterUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.RecruiterFullInfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("RecruiterUpdate"))
              .build();
        }
      }
    }
    return getRecruiterUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      com.google.protobuf.BoolValue> getUserDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserDelete",
      requestType = proto.ServerClient.UserMetaInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo,
      com.google.protobuf.BoolValue> getUserDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerClient.UserMetaInfo, com.google.protobuf.BoolValue> getUserDeleteMethod;
    if ((getUserDeleteMethod = UserServiceGrpc.getUserDeleteMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUserDeleteMethod = UserServiceGrpc.getUserDeleteMethod) == null) {
          UserServiceGrpc.getUserDeleteMethod = getUserDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerClient.UserMetaInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UserDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerClient.UserMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UserDelete"))
              .build();
        }
      }
    }
    return getUserDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void candidateCreate(proto.ServerClient.CandidateFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCandidateCreateMethod(), responseObserver);
    }

    /**
     */
    public void recruiterCreate(proto.ServerClient.RecruiterFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecruiterCreateMethod(), responseObserver);
    }

    /**
     */
    public void userRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUserReadMethod(), responseObserver);
    }

    /**
     */
    public void userListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserMetaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUserListReadMethod(), responseObserver);
    }

    /**
     */
    public void candidateRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCandidateReadMethod(), responseObserver);
    }

    /**
     */
    public void candidateListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCandidateListReadMethod(), responseObserver);
    }

    /**
     */
    public void recruiterRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecruiterReadMethod(), responseObserver);
    }

    /**
     */
    public void recruiterListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecruiterListReadMethod(), responseObserver);
    }

    /**
     */
    public void userUpdate(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUserUpdateMethod(), responseObserver);
    }

    /**
     */
    public void candidateUpdate(proto.ServerClient.CandidateFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCandidateUpdateMethod(), responseObserver);
    }

    /**
     */
    public void recruiterUpdate(proto.ServerClient.RecruiterFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecruiterUpdateMethod(), responseObserver);
    }

    /**
     */
    public void userDelete(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUserDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCandidateCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CandidateFullInfo,
                proto.ServerClient.CandidateFullInfo>(
                  this, METHODID_CANDIDATE_CREATE)))
          .addMethod(
            getRecruiterCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RecruiterFullInfo,
                proto.ServerClient.RecruiterFullInfo>(
                  this, METHODID_RECRUITER_CREATE)))
          .addMethod(
            getUserReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                proto.ServerClient.UserFullInfo>(
                  this, METHODID_USER_READ)))
          .addMethod(
            getUserListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.UserMetaInfo>(
                  this, METHODID_USER_LIST_READ)))
          .addMethod(
            getCandidateReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                proto.ServerClient.CandidateFullInfo>(
                  this, METHODID_CANDIDATE_READ)))
          .addMethod(
            getCandidateListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.CandidateFullInfo>(
                  this, METHODID_CANDIDATE_LIST_READ)))
          .addMethod(
            getRecruiterReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                proto.ServerClient.RecruiterFullInfo>(
                  this, METHODID_RECRUITER_READ)))
          .addMethod(
            getRecruiterListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.ServerClient.RecruiterFullInfo>(
                  this, METHODID_RECRUITER_LIST_READ)))
          .addMethod(
            getUserUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserFullInfo,
                proto.ServerClient.UserFullInfo>(
                  this, METHODID_USER_UPDATE)))
          .addMethod(
            getCandidateUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.CandidateFullInfo,
                proto.ServerClient.CandidateFullInfo>(
                  this, METHODID_CANDIDATE_UPDATE)))
          .addMethod(
            getRecruiterUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.RecruiterFullInfo,
                proto.ServerClient.RecruiterFullInfo>(
                  this, METHODID_RECRUITER_UPDATE)))
          .addMethod(
            getUserDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerClient.UserMetaInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_USER_DELETE)))
          .build();
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void candidateCreate(proto.ServerClient.CandidateFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCandidateCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recruiterCreate(proto.ServerClient.RecruiterFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecruiterCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUserReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserMetaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getUserListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void candidateRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCandidateReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void candidateListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCandidateListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recruiterRead(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecruiterReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recruiterListRead(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRecruiterListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userUpdate(proto.ServerClient.UserFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUserUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void candidateUpdate(proto.ServerClient.CandidateFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCandidateUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recruiterUpdate(proto.ServerClient.RecruiterFullInfo request,
        io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecruiterUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userDelete(proto.ServerClient.UserMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUserDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerClient.CandidateFullInfo candidateCreate(proto.ServerClient.CandidateFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCandidateCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.RecruiterFullInfo recruiterCreate(proto.ServerClient.RecruiterFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecruiterCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.UserFullInfo userRead(proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUserReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.UserMetaInfo> userListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getUserListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CandidateFullInfo candidateRead(proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCandidateReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.CandidateFullInfo> candidateListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCandidateListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.RecruiterFullInfo recruiterRead(proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecruiterReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerClient.RecruiterFullInfo> recruiterListRead(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRecruiterListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.UserFullInfo userUpdate(proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUserUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.CandidateFullInfo candidateUpdate(proto.ServerClient.CandidateFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCandidateUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerClient.RecruiterFullInfo recruiterUpdate(proto.ServerClient.RecruiterFullInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecruiterUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue userDelete(proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUserDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *OK
   * </pre>
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CandidateFullInfo> candidateCreate(
        proto.ServerClient.CandidateFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCandidateCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RecruiterFullInfo> recruiterCreate(
        proto.ServerClient.RecruiterFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecruiterCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.UserFullInfo> userRead(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUserReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CandidateFullInfo> candidateRead(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCandidateReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RecruiterFullInfo> recruiterRead(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecruiterReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.UserFullInfo> userUpdate(
        proto.ServerClient.UserFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUserUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.CandidateFullInfo> candidateUpdate(
        proto.ServerClient.CandidateFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCandidateUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerClient.RecruiterFullInfo> recruiterUpdate(
        proto.ServerClient.RecruiterFullInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecruiterUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> userDelete(
        proto.ServerClient.UserMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUserDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CANDIDATE_CREATE = 0;
  private static final int METHODID_RECRUITER_CREATE = 1;
  private static final int METHODID_USER_READ = 2;
  private static final int METHODID_USER_LIST_READ = 3;
  private static final int METHODID_CANDIDATE_READ = 4;
  private static final int METHODID_CANDIDATE_LIST_READ = 5;
  private static final int METHODID_RECRUITER_READ = 6;
  private static final int METHODID_RECRUITER_LIST_READ = 7;
  private static final int METHODID_USER_UPDATE = 8;
  private static final int METHODID_CANDIDATE_UPDATE = 9;
  private static final int METHODID_RECRUITER_UPDATE = 10;
  private static final int METHODID_USER_DELETE = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANDIDATE_CREATE:
          serviceImpl.candidateCreate((proto.ServerClient.CandidateFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo>) responseObserver);
          break;
        case METHODID_RECRUITER_CREATE:
          serviceImpl.recruiterCreate((proto.ServerClient.RecruiterFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo>) responseObserver);
          break;
        case METHODID_USER_READ:
          serviceImpl.userRead((proto.ServerClient.UserMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo>) responseObserver);
          break;
        case METHODID_USER_LIST_READ:
          serviceImpl.userListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.UserMetaInfo>) responseObserver);
          break;
        case METHODID_CANDIDATE_READ:
          serviceImpl.candidateRead((proto.ServerClient.UserMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo>) responseObserver);
          break;
        case METHODID_CANDIDATE_LIST_READ:
          serviceImpl.candidateListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo>) responseObserver);
          break;
        case METHODID_RECRUITER_READ:
          serviceImpl.recruiterRead((proto.ServerClient.UserMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo>) responseObserver);
          break;
        case METHODID_RECRUITER_LIST_READ:
          serviceImpl.recruiterListRead((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo>) responseObserver);
          break;
        case METHODID_USER_UPDATE:
          serviceImpl.userUpdate((proto.ServerClient.UserFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.UserFullInfo>) responseObserver);
          break;
        case METHODID_CANDIDATE_UPDATE:
          serviceImpl.candidateUpdate((proto.ServerClient.CandidateFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.CandidateFullInfo>) responseObserver);
          break;
        case METHODID_RECRUITER_UPDATE:
          serviceImpl.recruiterUpdate((proto.ServerClient.RecruiterFullInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerClient.RecruiterFullInfo>) responseObserver);
          break;
        case METHODID_USER_DELETE:
          serviceImpl.userDelete((proto.ServerClient.UserMetaInfo) request,
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCandidateCreateMethod())
              .addMethod(getRecruiterCreateMethod())
              .addMethod(getUserReadMethod())
              .addMethod(getUserListReadMethod())
              .addMethod(getCandidateReadMethod())
              .addMethod(getCandidateListReadMethod())
              .addMethod(getRecruiterReadMethod())
              .addMethod(getRecruiterListReadMethod())
              .addMethod(getUserUpdateMethod())
              .addMethod(getCandidateUpdateMethod())
              .addMethod(getRecruiterUpdateMethod())
              .addMethod(getUserDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
