package com.example.appxin.todoapp.models;

public class UserBody {
    private String username;
    private String email;
    private String password;

    public UserBody(String name, String email, String password) {
        this.username = name;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
