package com.ptworldcup.teams;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TeamsClient {
  private static final Logger log;
  static {
    System.setProperty("log4j.info", "");
    System.setProperty("log4j.configuration", "log4j.properties");
    log = LoggerFactory.getLogger(TeamsClient.class);
  }

  private final TeamsGrpc.TeamsBlockingStub blockingStub;

  public TeamsClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
  }

  public TeamsClient(ManagedChannelBuilder<?> channelBuilder) {
    ManagedChannel channel = channelBuilder.build();
    blockingStub = TeamsGrpc.newBlockingStub(channel);
  }

  public void getTeams() {
    try {
      TeamsOuterClass.GetTeamsResponse teamsResponse = blockingStub.getTeams(TeamsOuterClass.GetTeamsRequest.newBuilder().build());
      log.info(teamsResponse.toString());
    } catch (StatusRuntimeException e) {
      log.error("RPC failed: {}", e.getStatus());
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    log.info("Starting Teams client");

    String host = System.getenv("HOST");
    String portEnv = System.getenv("PORT");
    Integer port;
    try {
      port = Integer.valueOf(portEnv);
    } catch (NumberFormatException e) {
      log.error("PORT env variable must be a number, given " + portEnv);
      return;
    }

    TeamsClient teamsClient = new TeamsClient(host, port);
    teamsClient.getTeams();

    log.info("Teams client completed");
  }
}
