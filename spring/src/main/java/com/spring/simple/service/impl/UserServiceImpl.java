package com.spring.simple.service.impl;

import com.google.common.base.Preconditions;
import com.spring.simple.dao.UserDao;
import com.spring.simple.model.User;
import com.spring.simple.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 用户相关服务
 * Created by fengxu on 15-12-15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) throws IOException {
        Preconditions.checkNotNull(username, "参数错误");
        Preconditions.checkNotNull(password, "参数错误");

        return userDao.login(username, password);
    }
}
