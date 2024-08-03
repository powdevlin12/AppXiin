package com.example.appxin.todoapp.models.login;

import com.example.appxin.todoapp.models.User;

public class SuccessLogin {
    private boolean success;
    private String msg;
    private String token;
    private User user;

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}
