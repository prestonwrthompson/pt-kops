package com.ptworldcup.teams;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TeamsServer {
  private static final Logger LOGGER = LoggerFactory.getLogger(TeamsServer.class);

  private final Server server;
  private final int port;

  public TeamsServer(ServerBuilder<?> serverBuilder, int port) {
    this.port = port;
    server = serverBuilder.addService(new TeamsService())
      .build();
  }

  public TeamsServer(int port) {
    this(ServerBuilder.forPort(port), port);
  }

  public void start() throws IOException {
    server.start();
    LOGGER.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // The LOGGER may have been reset by its JVM shutdown hook, so attempt to use it but also log to stderr
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      try {
        LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
      } catch (Exception e) {
        System.err.println("*** unable to use logger during shutdown");
      }

      stop();

      try {
        LOGGER.error("*** server shut down");
      } catch (Exception e) {
        System.err.println("*** unable to use logger during shutdown");
      }
      System.err.println("*** server shut down");
    }));
  }

  public void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }
}

