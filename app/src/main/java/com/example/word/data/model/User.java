package com.example.word.data.model;

public class User {
  private String username;
  private double creditScore;
  private String fullName;
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setCreditScore(double creditScore) {
    this.creditScore = creditScore;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public double getCreditScore() {
    return creditScore;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassword() {
    return password;
  }

  public User() {}

  public User(String username, int creditScore, String fullName, String password) {
    this.username = username;
    this.creditScore = creditScore;
    this.fullName = fullName;
    this.password = password;
  }


}
