package com.ptworldcup.teams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Application {
  private static final Logger log;
  static {
    System.setProperty("log4j.debug", "");
    System.setProperty("log4j.configuration", "log4j.properties");
    log = LoggerFactory.getLogger(Application.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    log.info("Starting Teams application");
    TeamsServer server = new TeamsServer(getPort());
    server.start();
    server.blockUntilShutdown();
    log.info("Teams application startup completed");
  }

  private static Integer getPort() {
    String portEnv = System.getenv("PORT");
    try {
      return Integer.valueOf(portEnv);
    } catch (NumberFormatException e) {
      return 8980;
    }
  }
}
