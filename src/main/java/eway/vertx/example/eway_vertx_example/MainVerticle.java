package eway.vertx.example.eway_vertx_example;

import eway.vertx.example.eway_vertx_example.controller.CandidateController;
import eway.vertx.example.eway_vertx_example.controller.VoteController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    Router router = Router.router(vertx);
    // Register a body handler to be able to easily get the body from the request
    router.route().handler(BodyHandler.create());

    // Candidate route
    router.route(HttpMethod.GET, "/candidates/:candidate_id").handler(CandidateController::getCandidate);
    router.route(HttpMethod.GET, "/candidates").handler(CandidateController::listCandidates);
    router.route(HttpMethod.POST, "/candidates").handler(CandidateController::createCandidate);

    // Vote route
    router.route(HttpMethod.GET, "/votes").handler(VoteController::showVotes);
    router.route(HttpMethod.POST, "/votes").handler(VoteController::createVote);

    HttpServer server = vertx.createHttpServer().requestHandler(router).listen(8888);
  }
}
