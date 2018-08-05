package com.ptworldcup.teams;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: teams.proto")
public final class TeamsGrpc {

  private TeamsGrpc() {}

  public static final String SERVICE_NAME = "teams.Teams";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTeamsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest,
      com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> METHOD_GET_TEAMS = getGetTeamsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest,
      com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> getGetTeamsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest,
      com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> getGetTeamsMethod() {
    return getGetTeamsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest,
      com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> getGetTeamsMethodHelper() {
    io.grpc.MethodDescriptor<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest, com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> getGetTeamsMethod;
    if ((getGetTeamsMethod = TeamsGrpc.getGetTeamsMethod) == null) {
      synchronized (TeamsGrpc.class) {
        if ((getGetTeamsMethod = TeamsGrpc.getGetTeamsMethod) == null) {
          TeamsGrpc.getGetTeamsMethod = getGetTeamsMethod = 
              io.grpc.MethodDescriptor.<com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest, com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "teams.Teams", "GetTeams"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TeamsMethodDescriptorSupplier("GetTeams"))
                  .build();
          }
        }
     }
     return getGetTeamsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TeamsStub newStub(io.grpc.Channel channel) {
    return new TeamsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TeamsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TeamsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TeamsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TeamsFutureStub(channel);
  }

  /**
   */
  public static abstract class TeamsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTeams(com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest request,
        io.grpc.stub.StreamObserver<com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTeamsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTeamsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest,
                com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse>(
                  this, METHODID_GET_TEAMS)))
          .build();
    }
  }

  /**
   */
  public static final class TeamsStub extends io.grpc.stub.AbstractStub<TeamsStub> {
    private TeamsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeamsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeamsStub(channel, callOptions);
    }

    /**
     */
    public void getTeams(com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest request,
        io.grpc.stub.StreamObserver<com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTeamsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TeamsBlockingStub extends io.grpc.stub.AbstractStub<TeamsBlockingStub> {
    private TeamsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeamsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeamsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse getTeams(com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTeamsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TeamsFutureStub extends io.grpc.stub.AbstractStub<TeamsFutureStub> {
    private TeamsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeamsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeamsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse> getTeams(
        com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTeamsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TEAMS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TeamsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TeamsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TEAMS:
          serviceImpl.getTeams((com.ptworldcup.teams.TeamsOuterClass.GetTeamsRequest) request,
              (io.grpc.stub.StreamObserver<com.ptworldcup.teams.TeamsOuterClass.GetTeamsResponse>) responseObserver);
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

  private static abstract class TeamsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TeamsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ptworldcup.teams.TeamsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Teams");
    }
  }

  private static final class TeamsFileDescriptorSupplier
      extends TeamsBaseDescriptorSupplier {
    TeamsFileDescriptorSupplier() {}
  }

  private static final class TeamsMethodDescriptorSupplier
      extends TeamsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TeamsMethodDescriptorSupplier(String methodName) {
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
      synchronized (TeamsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TeamsFileDescriptorSupplier())
              .addMethod(getGetTeamsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
