package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: ServerChat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GroupServiceGrpc {

  private GroupServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.GroupService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupCreate",
      requestType = proto.ServerChat.GroupMetaInfo.class,
      responseType = proto.ServerChat.GroupMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupCreateMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo> getGroupCreateMethod;
    if ((getGroupCreateMethod = GroupServiceGrpc.getGroupCreateMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupCreateMethod = GroupServiceGrpc.getGroupCreateMethod) == null) {
          GroupServiceGrpc.getGroupCreateMethod = getGroupCreateMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupCreate"))
              .build();
        }
      }
    }
    return getGroupCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupRead",
      requestType = proto.ServerChat.GroupMetaInfo.class,
      responseType = proto.ServerChat.GroupMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo> getGroupReadMethod;
    if ((getGroupReadMethod = GroupServiceGrpc.getGroupReadMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupReadMethod = GroupServiceGrpc.getGroupReadMethod) == null) {
          GroupServiceGrpc.getGroupReadMethod = getGroupReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupRead"))
              .build();
        }
      }
    }
    return getGroupReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      proto.ServerChat.GroupMetaInfo> getGroupListReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupListRead",
      requestType = proto.ServerChat.GroupMemeber.class,
      responseType = proto.ServerChat.GroupMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      proto.ServerChat.GroupMetaInfo> getGroupListReadMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber, proto.ServerChat.GroupMetaInfo> getGroupListReadMethod;
    if ((getGroupListReadMethod = GroupServiceGrpc.getGroupListReadMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupListReadMethod = GroupServiceGrpc.getGroupListReadMethod) == null) {
          GroupServiceGrpc.getGroupListReadMethod = getGroupListReadMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMemeber, proto.ServerChat.GroupMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupListRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMemeber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupListRead"))
              .build();
        }
      }
    }
    return getGroupListReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupUpdateInfo",
      requestType = proto.ServerChat.GroupMetaInfo.class,
      responseType = proto.ServerChat.GroupMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      proto.ServerChat.GroupMetaInfo> getGroupUpdateInfoMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo> getGroupUpdateInfoMethod;
    if ((getGroupUpdateInfoMethod = GroupServiceGrpc.getGroupUpdateInfoMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupUpdateInfoMethod = GroupServiceGrpc.getGroupUpdateInfoMethod) == null) {
          GroupServiceGrpc.getGroupUpdateInfoMethod = getGroupUpdateInfoMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMetaInfo, proto.ServerChat.GroupMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupUpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupUpdateInfo"))
              .build();
        }
      }
    }
    return getGroupUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      com.google.protobuf.BoolValue> getGroupDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupDelete",
      requestType = proto.ServerChat.GroupMetaInfo.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo,
      com.google.protobuf.BoolValue> getGroupDeleteMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMetaInfo, com.google.protobuf.BoolValue> getGroupDeleteMethod;
    if ((getGroupDeleteMethod = GroupServiceGrpc.getGroupDeleteMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupDeleteMethod = GroupServiceGrpc.getGroupDeleteMethod) == null) {
          GroupServiceGrpc.getGroupDeleteMethod = getGroupDeleteMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMetaInfo, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupDelete"))
              .build();
        }
      }
    }
    return getGroupDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      proto.ServerChat.GroupMetaInfo> getGroupAppendMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupAppendMember",
      requestType = proto.ServerChat.GroupMemeber.class,
      responseType = proto.ServerChat.GroupMetaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      proto.ServerChat.GroupMetaInfo> getGroupAppendMemberMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber, proto.ServerChat.GroupMetaInfo> getGroupAppendMemberMethod;
    if ((getGroupAppendMemberMethod = GroupServiceGrpc.getGroupAppendMemberMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupAppendMemberMethod = GroupServiceGrpc.getGroupAppendMemberMethod) == null) {
          GroupServiceGrpc.getGroupAppendMemberMethod = getGroupAppendMemberMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMemeber, proto.ServerChat.GroupMetaInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupAppendMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMemeber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMetaInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupAppendMember"))
              .build();
        }
      }
    }
    return getGroupAppendMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      com.google.protobuf.BoolValue> getGroupDeleteMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupDeleteMember",
      requestType = proto.ServerChat.GroupMemeber.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber,
      com.google.protobuf.BoolValue> getGroupDeleteMemberMethod() {
    io.grpc.MethodDescriptor<proto.ServerChat.GroupMemeber, com.google.protobuf.BoolValue> getGroupDeleteMemberMethod;
    if ((getGroupDeleteMemberMethod = GroupServiceGrpc.getGroupDeleteMemberMethod) == null) {
      synchronized (GroupServiceGrpc.class) {
        if ((getGroupDeleteMemberMethod = GroupServiceGrpc.getGroupDeleteMemberMethod) == null) {
          GroupServiceGrpc.getGroupDeleteMemberMethod = getGroupDeleteMemberMethod =
              io.grpc.MethodDescriptor.<proto.ServerChat.GroupMemeber, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupDeleteMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ServerChat.GroupMemeber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new GroupServiceMethodDescriptorSupplier("GroupDeleteMember"))
              .build();
        }
      }
    }
    return getGroupDeleteMemberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GroupServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupServiceStub>() {
        @java.lang.Override
        public GroupServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupServiceStub(channel, callOptions);
        }
      };
    return GroupServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GroupServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupServiceBlockingStub>() {
        @java.lang.Override
        public GroupServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupServiceBlockingStub(channel, callOptions);
        }
      };
    return GroupServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GroupServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupServiceFutureStub>() {
        @java.lang.Override
        public GroupServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupServiceFutureStub(channel, callOptions);
        }
      };
    return GroupServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GroupServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void groupCreate(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupCreateMethod(), responseObserver);
    }

    /**
     */
    public void groupRead(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupReadMethod(), responseObserver);
    }

    /**
     */
    public void groupListRead(proto.ServerChat.GroupMemeber request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupListReadMethod(), responseObserver);
    }

    /**
     */
    public void groupUpdateInfo(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void groupDelete(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupDeleteMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<proto.ServerChat.GroupMemeber> groupAppendMember(
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGroupAppendMemberMethod(), responseObserver);
    }

    /**
     */
    public void groupDeleteMember(proto.ServerChat.GroupMemeber request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupDeleteMemberMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGroupCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.GroupMetaInfo,
                proto.ServerChat.GroupMetaInfo>(
                  this, METHODID_GROUP_CREATE)))
          .addMethod(
            getGroupReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.GroupMetaInfo,
                proto.ServerChat.GroupMetaInfo>(
                  this, METHODID_GROUP_READ)))
          .addMethod(
            getGroupListReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto.ServerChat.GroupMemeber,
                proto.ServerChat.GroupMetaInfo>(
                  this, METHODID_GROUP_LIST_READ)))
          .addMethod(
            getGroupUpdateInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.GroupMetaInfo,
                proto.ServerChat.GroupMetaInfo>(
                  this, METHODID_GROUP_UPDATE_INFO)))
          .addMethod(
            getGroupDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.GroupMetaInfo,
                com.google.protobuf.BoolValue>(
                  this, METHODID_GROUP_DELETE)))
          .addMethod(
            getGroupAppendMemberMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                proto.ServerChat.GroupMemeber,
                proto.ServerChat.GroupMetaInfo>(
                  this, METHODID_GROUP_APPEND_MEMBER)))
          .addMethod(
            getGroupDeleteMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.ServerChat.GroupMemeber,
                com.google.protobuf.BoolValue>(
                  this, METHODID_GROUP_DELETE_MEMBER)))
          .build();
    }
  }

  /**
   */
  public static final class GroupServiceStub extends io.grpc.stub.AbstractAsyncStub<GroupServiceStub> {
    private GroupServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupServiceStub(channel, callOptions);
    }

    /**
     */
    public void groupCreate(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupRead(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupListRead(proto.ServerChat.GroupMemeber request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGroupListReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupUpdateInfo(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupDelete(proto.ServerChat.GroupMetaInfo request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<proto.ServerChat.GroupMemeber> groupAppendMember(
        io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGroupAppendMemberMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void groupDeleteMember(proto.ServerChat.GroupMemeber request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupDeleteMemberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GroupServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GroupServiceBlockingStub> {
    private GroupServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ServerChat.GroupMetaInfo groupCreate(proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerChat.GroupMetaInfo groupRead(proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.ServerChat.GroupMetaInfo> groupListRead(
        proto.ServerChat.GroupMemeber request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGroupListReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ServerChat.GroupMetaInfo groupUpdateInfo(proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue groupDelete(proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue groupDeleteMember(proto.ServerChat.GroupMemeber request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupDeleteMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GroupServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GroupServiceFutureStub> {
    private GroupServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.GroupMetaInfo> groupCreate(
        proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.GroupMetaInfo> groupRead(
        proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ServerChat.GroupMetaInfo> groupUpdateInfo(
        proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> groupDelete(
        proto.ServerChat.GroupMetaInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> groupDeleteMember(
        proto.ServerChat.GroupMemeber request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupDeleteMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GROUP_CREATE = 0;
  private static final int METHODID_GROUP_READ = 1;
  private static final int METHODID_GROUP_LIST_READ = 2;
  private static final int METHODID_GROUP_UPDATE_INFO = 3;
  private static final int METHODID_GROUP_DELETE = 4;
  private static final int METHODID_GROUP_DELETE_MEMBER = 5;
  private static final int METHODID_GROUP_APPEND_MEMBER = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GroupServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GroupServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GROUP_CREATE:
          serviceImpl.groupCreate((proto.ServerChat.GroupMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo>) responseObserver);
          break;
        case METHODID_GROUP_READ:
          serviceImpl.groupRead((proto.ServerChat.GroupMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo>) responseObserver);
          break;
        case METHODID_GROUP_LIST_READ:
          serviceImpl.groupListRead((proto.ServerChat.GroupMemeber) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo>) responseObserver);
          break;
        case METHODID_GROUP_UPDATE_INFO:
          serviceImpl.groupUpdateInfo((proto.ServerChat.GroupMetaInfo) request,
              (io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo>) responseObserver);
          break;
        case METHODID_GROUP_DELETE:
          serviceImpl.groupDelete((proto.ServerChat.GroupMetaInfo) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GROUP_DELETE_MEMBER:
          serviceImpl.groupDeleteMember((proto.ServerChat.GroupMemeber) request,
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
        case METHODID_GROUP_APPEND_MEMBER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.groupAppendMember(
              (io.grpc.stub.StreamObserver<proto.ServerChat.GroupMetaInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GroupServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ServerChat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GroupService");
    }
  }

  private static final class GroupServiceFileDescriptorSupplier
      extends GroupServiceBaseDescriptorSupplier {
    GroupServiceFileDescriptorSupplier() {}
  }

  private static final class GroupServiceMethodDescriptorSupplier
      extends GroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GroupServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GroupServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GroupServiceFileDescriptorSupplier())
              .addMethod(getGroupCreateMethod())
              .addMethod(getGroupReadMethod())
              .addMethod(getGroupListReadMethod())
              .addMethod(getGroupUpdateInfoMethod())
              .addMethod(getGroupDeleteMethod())
              .addMethod(getGroupAppendMemberMethod())
              .addMethod(getGroupDeleteMemberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
