package com.example.appxin.todoapp.models;

public class User {
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String _id;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
