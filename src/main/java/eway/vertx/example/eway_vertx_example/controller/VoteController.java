package eway.vertx.example.eway_vertx_example.controller;

import eway.vertx.example.eway_vertx_example.Runner;
import eway.vertx.example.eway_vertx_example.model.Candidate;
import io.vertx.ext.web.RoutingContext;

import java.util.stream.Collectors;

public class VoteController {

  public static void createVote(RoutingContext context){
    Candidate voteCandidate = Runner.candidate.get(context.request().getParam("id"));
    if (voteCandidate == null){
      context.response().write("Candidate not exist!").end();
    }
    voteCandidate.getVotes().intValue();
    context.response().write("Vote success!").end();
  }

  public static void showVotes(RoutingContext context){
    String response = Runner.candidate.values().parallelStream().map( it -> {
      return new Candidate(it.getName(), it.getVotes());
    }).collect(Collectors.toList()).toString();
    context.response().write(response).end();
  }

  public static void listPollsResult(RoutingContext context){
    String response = Runner.candidate.values().toString();
    context.response().write(response).end();
  }
}
