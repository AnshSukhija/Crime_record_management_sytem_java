package com.crimeapp;
public abstract class User {
 protected String username;
 protected String password;
 public User(String username, String password) {
     this.username = username;
     this.password = password;
 }
 public abstract boolean login(String user, String pass);
}
