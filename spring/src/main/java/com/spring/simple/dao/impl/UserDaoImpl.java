package com.spring.simple.dao.impl;

import com.spring.simple.dao.UserDao;
import com.spring.simple.model.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Properties;

/**
 * userDao
 * Created by fengxu on 15-12-15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    public static final String ACCOUNT_PROPERTY = UserDaoImpl.class.getResource("/").getPath() + "account.properties";

    @Override
    public User login(String username, String password) throws IOException {
        Properties props = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(ACCOUNT_PROPERTY));
        props.load(in);

        User user = null;
        if (null != props.get(username) && password.equals(props.get(username))) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
        }
        return user;
    }
}
