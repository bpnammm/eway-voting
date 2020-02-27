package eway.vertx.example.eway_vertx_example.model;

public class Candidate {
  String candidateId;
  String name;
  long votes;

  public Candidate(String candidateId, String name, long votes) {
    this.candidateId = candidateId;
    this.name = name;
    this.votes = votes;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getVotes() {
    return votes;
  }

  public void setVotes(long votes) {
    this.votes = votes;
  }
}
