package eway.vertx.example.eway_vertx_example.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Candidate {
  String id;
  String name;
  AtomicInteger votes;

  public Candidate(String name, AtomicInteger votes) {
    this.name = name;
    this.votes = votes;
  }

  public Candidate(String id, String name, AtomicInteger votes) {
    this.id = id;
    this.name = name;
    this.votes = votes;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AtomicInteger getVotes() {
    return votes;
  }

  public void setVotes(AtomicInteger votes) {
    this.votes = votes;
  }
}
