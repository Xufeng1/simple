package com.spring.simple.model.api;

/**
 * 用户登录表单对象
 * Created by fengxu on 15-12-15.
 */
public class UserLoginParams {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
