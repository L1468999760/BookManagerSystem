package com.nowcoder.demo.model;

public class User {

    private int id;

    private String name;

    private String email;

    private String password;

    private int isOnline;

    public int getOnline() {
        return isOnline;
    }

    public void setOnline(int online) {
        isOnline = online;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
