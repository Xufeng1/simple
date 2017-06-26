/*
 * Copyright (c) 2015 Qunar.com. All Rights Reserved.
 */
package com.spring.simple.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final MappingJackson2JsonView JSON_VIEW = new MappingJackson2JsonView();

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object handler, Exception ex) {

        logger.error("exception caught!! reason:{}, e:", ex.getMessage(), ex);

        if (!(handler instanceof HandlerMethod)) {
            return buildErrorPage();
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
        if (responseBody == null) {
            // 页面请求
            return buildErrorPage();
        } else {
            // JSON请求
            return buildErrorJson(ex);
        }
    }

    private ModelAndView buildErrorPage() {
        return new ModelAndView("forward:/error/500.html");
    }

    private ModelAndView buildErrorJson(Exception ex) {
        ModelAndView modelAndView = new ModelAndView(JSON_VIEW);
        modelAndView.addObject("status", -1);
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("data", null);
        return modelAndView;
    }
}
