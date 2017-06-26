package com.spring.simple.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * cookie工具类
 * Created by fengxu on 15-12-10.
 */
@SuppressWarnings("all")
public class CookieUtil {

    /**
     * 创建Cookie
     *
     * @param key    键
     * @param value  值
     * @param maxAge 有效期，默认为-1，关闭浏览器消失，如果为0，表示删除cookie
     * @return Cookie
     */
    public static Cookie addCreate(String key, String value, Integer maxAge) {
        if (maxAge == null) {
            maxAge = -1;
        }
        if (null == value || "".equals(value)) {
            maxAge = 0;
        }
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    /**
     * 获取cookie信息
     *
     * @param request 请求信息
     * @param key     键
     * @return Cookie值
     */
    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            if (cookies.length != 0 || key != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(key)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }
}
