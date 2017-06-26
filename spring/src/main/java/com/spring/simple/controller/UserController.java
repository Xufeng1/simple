package com.spring.simple.controller;

import com.spring.simple.model.ApiResult;
import com.spring.simple.model.User;
import com.spring.simple.model.api.UserLoginParams;
import com.spring.simple.service.UserService;
import com.spring.simple.util.CookieUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 用户控制层
 * Created by fengxu on 15-12-15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = getLogger(UserController.class);

    public static final Integer DEFAULT_COOKIE_ACTIVE = null;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult login(@RequestBody UserLoginParams userLoginParams,
                        HttpServletResponse response) throws IOException {

        ApiResult<User> result = new ApiResult<>();

        User user = userService.login(userLoginParams.getUsername(), userLoginParams.getPassword());
        if (user != null) {
            response.addCookie(CookieUtil.addCreate("username", user.getUsername(), DEFAULT_COOKIE_ACTIVE));
            logger.info("用户已登录：{}", user.getUsername());
            return result.success("登录成功！", user);
        }
        return result.fail(-1, "登录失败！用户名或密码不正确");
    }

    @RequestMapping(value = "/exist", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult exist(HttpServletResponse response) {

        ApiResult<String> result = new ApiResult<>();

        Cookie cookie = CookieUtil.addCreate("username", "", 0);
        response.addCookie(cookie);
        return result.success("退出登录成功！", null);
    }

}
