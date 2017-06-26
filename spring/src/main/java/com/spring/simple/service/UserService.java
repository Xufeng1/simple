package com.spring.simple.service;

import com.spring.simple.model.User;

import java.io.IOException;

/**
 * 用户服务接口
 * Created by fengxu on 15-12-15.
 */
public interface UserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    User login(String username, String password) throws IOException;
}
