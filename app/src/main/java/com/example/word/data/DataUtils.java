
package com.example.word.data;


import com.example.word.data.model.Challenge;
import com.example.word.data.model.User;
import com.annimon.stream.Stream;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class DataUtils {
  private static User[] userList;
  private static Challenge[] challengeList;
  private static String currUser = "";

  static {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      String userJson =
              new Scanner(DataUtils.class.getResourceAsStream("/user.json"), "UTF-8")
                      .useDelimiter("\\A").next();
      String ChallengeJson =
              new Scanner(DataUtils.class.getResourceAsStream("/challenge.json"), "UTF-8")
                      .useDelimiter("\\A").next();
      userList = mapper.readValue(userJson, User[].class);
      challengeList = mapper.readValue(ChallengeJson, Challenge[].class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static User[] getUsers() {
    return userList;
  }

  public static User getUser(String userName) {
    for (User user : userList) {
      if (user.getUsername().equals(userName)) return user;
    }
    return new User();
  }

  public static Challenge[] getActiveChallenge(String username) {
    return Stream.of(challengeList).filter(c -> {
      boolean isChallenged = c.getChallenged().equals(username);
      boolean isChallenger = c.getChallenger().equals(username);
      boolean statusMatch = c.getStatus() == 1;
      return statusMatch && (isChallenged || isChallenger);
    }).toArray(Challenge[]::new);
  }

  public static Challenge[] getPendingPenalty(String username) {
    return Stream.of(challengeList).filter(c -> {
      boolean isChallenged = c.getChallenged().equals(username);
      boolean isChallenger = c.getChallenger().equals(username);
      boolean statusMatch = c.getStatus() == Challenge.WAITING_PENALTY;
      return statusMatch && (isChallenged || isChallenger);
    }).toArray(Challenge[]::new);
  }

  public static Challenge[] getUnresolvedChallenge(String username) {
    return Stream.of(challengeList).filter(c -> {
      boolean isChallenged = c.getChallenged().equals(username);
      boolean isChallenger = c.getChallenger().equals(username);
      boolean statusMatch = c.getStatus() == Challenge.UNRESOLVED;
      return statusMatch && (isChallenged || isChallenger);
    }).toArray(Challenge[]::new);
  }

  public static Challenge[] getPendingInvitation(String username) {
    return Stream.of(challengeList).filter(c -> {
      boolean isChallenged = c.getChallenged().equals(username);
      boolean isChallenger = c.getChallenger().equals(username);
      boolean counterSend = c.getStatus() == Challenge.COUNTER_CHALLENGED;
      boolean send = c.getStatus() == Challenge.SEND;
      return (isChallenged && send) || (isChallenger && counterSend);
    }).toArray(Challenge[]::new);
  }

  public static Challenge getChallenge(int id) {
    for (Challenge challenge : challengeList) {
      if (challenge.getId() == id) return challenge;
    }
    return new Challenge();
  }

  public static Challenge[] getCompleteChallenges(String username) {
    return Stream.of(challengeList).filter(c -> {
      boolean isChallenged = c.getChallenged().equals(username);
      boolean isChallenger = c.getChallenger().equals(username);
      boolean statusMatch = c.getStatus() == Challenge.COMPLETED;
      return statusMatch && (isChallenged || isChallenger);
    }).toArray(Challenge[]::new);
  }

  public static String getCurrUser() {
    return currUser;
  }

  public static void setCurrUser(String user) {
    DataUtils.currUser = user;
  }
}
