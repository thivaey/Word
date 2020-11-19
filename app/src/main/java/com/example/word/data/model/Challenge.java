package com.example.word.data.model;

import java.util.Objects;

public class Challenge {
  public static final int ACTIVE = 1;
  public static final int SEND = 2;
  public static final int COUNTER_CHALLENGED = 3;
  public static final int WAITING_PENALTY = 4;
  public static final int UNRESOLVED = 5;
  public static final int COMPLETED = 6;
  public static final int VOTING_INVITATION = 7;

  private String challenger;
  private String challenged;
  private String startDate;
  private String description;
  private String endDate;
  private String penaltyByChallenger;
  private String penaltyByChallenged;
  private String finalPenalty;
  private String winner;
  private int status;

  public Challenge() {}

  public String getChallenger() {
    return challenger;
  }

  public String getChallenged() {
    return challenged;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getDescription() {
    return description;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getPenaltyByChallenger() {
    return penaltyByChallenger;
  }

  public int getId() {
    return this.hashCode();
  }

  public String getPenaltyByChallenged() {
    return penaltyByChallenged;
  }

  public String getFinalPenalty() {
    return finalPenalty;
  }

  public String getWinner() {
    return winner;
  }

  public int getStatus() {
    return status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(challenger, challenged,
            startDate, description, endDate,
            penaltyByChallenger, penaltyByChallenged,
            finalPenalty, winner, status);
  }
}
