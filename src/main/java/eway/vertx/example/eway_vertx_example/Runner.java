package eway.vertx.example.eway_vertx_example;

import eway.vertx.example.eway_vertx_example.model.Candidate;
import io.vertx.core.Context;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

  public static final Map<String, Candidate> candidate = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx(new VertxOptions());
    vertx.deployVerticle(MainVerticle.class.getName(), new DeploymentOptions().setInstances(100), res -> {
      if (res.succeeded()) {
        System.out.println("MainVerticle deployment id is: " + res.result());
      } else {
        System.out.println("MainVerticle deployment failed!");
      }
    });
  }


}
