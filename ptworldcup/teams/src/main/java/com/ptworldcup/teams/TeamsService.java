package com.ptworldcup.teams;

import io.grpc.stub.StreamObserver;
import com.ptworldcup.teams.TeamsOuterClass.*;

import java.util.ArrayList;

public class TeamsService extends TeamsGrpc.TeamsImplBase {
  public void getTeams(GetTeamsRequest getTeamsRequest, StreamObserver<GetTeamsResponse> responseObserver) {
    responseObserver.onNext(getTeams(getTeamsRequest));
    responseObserver.onCompleted();
  }

  private GetTeamsResponse getTeams(GetTeamsRequest getTeamsRequest) {
    ArrayList<Team> teams = new ArrayList<>();
    Team portugal = Team.newBuilder().setColor("green and red").setId("abcabcabcabcabca").setName("Portugal").build();
    teams.add(portugal);
    Team spain = Team.newBuilder().setColor("red and yellow").setId("0120120120120120").setName("Spain").build();
    teams.add(spain);
    Team germany = Team.newBuilder().setColor("yellow black and red").setId("3453453453453453").setName("Germany").build();
    teams.add(germany);
    return GetTeamsResponse.newBuilder().addAllTeams(teams).build();
  }
}
