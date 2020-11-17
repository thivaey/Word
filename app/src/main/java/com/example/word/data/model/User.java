package com.example.word.data.model;

public class User {
  private String username;
  private double rating;
  private String fullName;
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setRating(double rating) {
    this.rating = rating;
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

  public double getRating() {
    return rating;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassword() {
    return password;
  }

  public User() {}

  public User(String username, int rating, String fullName, String password) {
    this.username = username;
    this.rating = rating;
    this.fullName = fullName;
    this.password = password;
  }


}
