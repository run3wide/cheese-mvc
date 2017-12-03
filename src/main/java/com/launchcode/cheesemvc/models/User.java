package com.launchcode.cheesemvc.models;

public class User {


    private int id;
    private String userName;
    private String email;
    private String password;
    private static int nextId = 0;

    public User() {
        updateNextId();
        this.id = nextId;
    }

    private static void updateNextId() {
        nextId = nextId++;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
