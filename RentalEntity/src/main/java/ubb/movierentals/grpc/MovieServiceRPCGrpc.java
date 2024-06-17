package ubb.movierentals.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: movie.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MovieServiceRPCGrpc {

  private MovieServiceRPCGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ubb.movierentals.grpc.MovieServiceRPC";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest,
      ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> getGetAllMoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllMovies",
      requestType = ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest.class,
      responseType = ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest,
      ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> getGetAllMoviesMethod() {
    io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest, ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> getGetAllMoviesMethod;
    if ((getGetAllMoviesMethod = MovieServiceRPCGrpc.getGetAllMoviesMethod) == null) {
      synchronized (MovieServiceRPCGrpc.class) {
        if ((getGetAllMoviesMethod = MovieServiceRPCGrpc.getGetAllMoviesMethod) == null) {
          MovieServiceRPCGrpc.getGetAllMoviesMethod = getGetAllMoviesMethod =
              io.grpc.MethodDescriptor.<ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest, ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllMovies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceRPCMethodDescriptorSupplier("getAllMovies"))
              .build();
        }
      }
    }
    return getGetAllMoviesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> getGetMovieByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMovieById",
      requestType = ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest.class,
      responseType = ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> getGetMovieByIdMethod() {
    io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest, ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> getGetMovieByIdMethod;
    if ((getGetMovieByIdMethod = MovieServiceRPCGrpc.getGetMovieByIdMethod) == null) {
      synchronized (MovieServiceRPCGrpc.class) {
        if ((getGetMovieByIdMethod = MovieServiceRPCGrpc.getGetMovieByIdMethod) == null) {
          MovieServiceRPCGrpc.getGetMovieByIdMethod = getGetMovieByIdMethod =
              io.grpc.MethodDescriptor.<ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest, ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMovieById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceRPCMethodDescriptorSupplier("getMovieById"))
              .build();
        }
      }
    }
    return getGetMovieByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> getAddMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addMovie",
      requestType = ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest.class,
      responseType = ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> getAddMovieMethod() {
    io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest, ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> getAddMovieMethod;
    if ((getAddMovieMethod = MovieServiceRPCGrpc.getAddMovieMethod) == null) {
      synchronized (MovieServiceRPCGrpc.class) {
        if ((getAddMovieMethod = MovieServiceRPCGrpc.getAddMovieMethod) == null) {
          MovieServiceRPCGrpc.getAddMovieMethod = getAddMovieMethod =
              io.grpc.MethodDescriptor.<ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest, ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceRPCMethodDescriptorSupplier("addMovie"))
              .build();
        }
      }
    }
    return getAddMovieMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> getUpdateMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateMovie",
      requestType = ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest.class,
      responseType = ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> getUpdateMovieMethod() {
    io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest, ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> getUpdateMovieMethod;
    if ((getUpdateMovieMethod = MovieServiceRPCGrpc.getUpdateMovieMethod) == null) {
      synchronized (MovieServiceRPCGrpc.class) {
        if ((getUpdateMovieMethod = MovieServiceRPCGrpc.getUpdateMovieMethod) == null) {
          MovieServiceRPCGrpc.getUpdateMovieMethod = getUpdateMovieMethod =
              io.grpc.MethodDescriptor.<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest, ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceRPCMethodDescriptorSupplier("updateMovie"))
              .build();
        }
      }
    }
    return getUpdateMovieMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> getDeleteMovieByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteMovieById",
      requestType = ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest.class,
      responseType = ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest,
      ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> getDeleteMovieByIdMethod() {
    io.grpc.MethodDescriptor<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest, ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> getDeleteMovieByIdMethod;
    if ((getDeleteMovieByIdMethod = MovieServiceRPCGrpc.getDeleteMovieByIdMethod) == null) {
      synchronized (MovieServiceRPCGrpc.class) {
        if ((getDeleteMovieByIdMethod = MovieServiceRPCGrpc.getDeleteMovieByIdMethod) == null) {
          MovieServiceRPCGrpc.getDeleteMovieByIdMethod = getDeleteMovieByIdMethod =
              io.grpc.MethodDescriptor.<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest, ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteMovieById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceRPCMethodDescriptorSupplier("deleteMovieById"))
              .build();
        }
      }
    }
    return getDeleteMovieByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieServiceRPCStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCStub>() {
        @java.lang.Override
        public MovieServiceRPCStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceRPCStub(channel, callOptions);
        }
      };
    return MovieServiceRPCStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieServiceRPCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCBlockingStub>() {
        @java.lang.Override
        public MovieServiceRPCBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceRPCBlockingStub(channel, callOptions);
        }
      };
    return MovieServiceRPCBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieServiceRPCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceRPCFutureStub>() {
        @java.lang.Override
        public MovieServiceRPCFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceRPCFutureStub(channel, callOptions);
        }
      };
    return MovieServiceRPCFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAllMovies(ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMoviesMethod(), responseObserver);
    }

    /**
     */
    default void getMovieById(ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieByIdMethod(), responseObserver);
    }

    /**
     */
    default void addMovie(ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMovieMethod(), responseObserver);
    }

    /**
     */
    default void updateMovie(ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMovieMethod(), responseObserver);
    }

    /**
     */
    default void deleteMovieById(ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMovieByIdMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MovieServiceRPC.
   */
  public static abstract class MovieServiceRPCImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MovieServiceRPCGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MovieServiceRPC.
   */
  public static final class MovieServiceRPCStub
      extends io.grpc.stub.AbstractAsyncStub<MovieServiceRPCStub> {
    private MovieServiceRPCStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceRPCStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceRPCStub(channel, callOptions);
    }

    /**
     */
    public void getAllMovies(ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMoviesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMovieById(ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addMovie(ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMovieMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMovie(ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMovieMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMovieById(ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest request,
        io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMovieByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MovieServiceRPC.
   */
  public static final class MovieServiceRPCBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MovieServiceRPCBlockingStub> {
    private MovieServiceRPCBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceRPCBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceRPCBlockingStub(channel, callOptions);
    }

    /**
     */
    public ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse getAllMovies(ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMoviesMethod(), getCallOptions(), request);
    }

    /**
     */
    public ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse getMovieById(ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse addMovie(ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMovieMethod(), getCallOptions(), request);
    }

    /**
     */
    public ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse updateMovie(ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMovieMethod(), getCallOptions(), request);
    }

    /**
     */
    public ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse deleteMovieById(ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMovieByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MovieServiceRPC.
   */
  public static final class MovieServiceRPCFutureStub
      extends io.grpc.stub.AbstractFutureStub<MovieServiceRPCFutureStub> {
    private MovieServiceRPCFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceRPCFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceRPCFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse> getAllMovies(
        ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMoviesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse> getMovieById(
        ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse> addMovie(
        ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMovieMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse> updateMovie(
        ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMovieMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse> deleteMovieById(
        ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMovieByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_MOVIES = 0;
  private static final int METHODID_GET_MOVIE_BY_ID = 1;
  private static final int METHODID_ADD_MOVIE = 2;
  private static final int METHODID_UPDATE_MOVIE = 3;
  private static final int METHODID_DELETE_MOVIE_BY_ID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_MOVIES:
          serviceImpl.getAllMovies((ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest) request,
              (io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse>) responseObserver);
          break;
        case METHODID_GET_MOVIE_BY_ID:
          serviceImpl.getMovieById((ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest) request,
              (io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse>) responseObserver);
          break;
        case METHODID_ADD_MOVIE:
          serviceImpl.addMovie((ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest) request,
              (io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MOVIE:
          serviceImpl.updateMovie((ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest) request,
              (io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse>) responseObserver);
          break;
        case METHODID_DELETE_MOVIE_BY_ID:
          serviceImpl.deleteMovieById((ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest) request,
              (io.grpc.stub.StreamObserver<ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAllMoviesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ubb.movierentals.grpc.MovieOuterClass.GetMoviesRequest,
              ubb.movierentals.grpc.MovieOuterClass.GetMoviesResponse>(
                service, METHODID_GET_ALL_MOVIES)))
        .addMethod(
          getGetMovieByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ubb.movierentals.grpc.MovieOuterClass.GetMovieRequest,
              ubb.movierentals.grpc.MovieOuterClass.GetMovieResponse>(
                service, METHODID_GET_MOVIE_BY_ID)))
        .addMethod(
          getAddMovieMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ubb.movierentals.grpc.MovieOuterClass.AddMovieRequest,
              ubb.movierentals.grpc.MovieOuterClass.AddMovieResponse>(
                service, METHODID_ADD_MOVIE)))
        .addMethod(
          getUpdateMovieMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ubb.movierentals.grpc.MovieOuterClass.UpdateMovieRequest,
              ubb.movierentals.grpc.MovieOuterClass.UpdateMovieResponse>(
                service, METHODID_UPDATE_MOVIE)))
        .addMethod(
          getDeleteMovieByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ubb.movierentals.grpc.MovieOuterClass.DeleteMovieRequest,
              ubb.movierentals.grpc.MovieOuterClass.DeleteMovieResponse>(
                service, METHODID_DELETE_MOVIE_BY_ID)))
        .build();
  }

  private static abstract class MovieServiceRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieServiceRPCBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ubb.movierentals.grpc.MovieOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieServiceRPC");
    }
  }

  private static final class MovieServiceRPCFileDescriptorSupplier
      extends MovieServiceRPCBaseDescriptorSupplier {
    MovieServiceRPCFileDescriptorSupplier() {}
  }

  private static final class MovieServiceRPCMethodDescriptorSupplier
      extends MovieServiceRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MovieServiceRPCMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MovieServiceRPCGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieServiceRPCFileDescriptorSupplier())
              .addMethod(getGetAllMoviesMethod())
              .addMethod(getGetMovieByIdMethod())
              .addMethod(getAddMovieMethod())
              .addMethod(getUpdateMovieMethod())
              .addMethod(getDeleteMovieByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
