package com.spring.simple.dao;

import com.spring.simple.model.User;
import java.io.IOException;

/**
 * 用户相关
 * Created by fengxu on 15-12-15.
 */
public interface UserDao {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User login(String username, String password) throws IOException;
}
