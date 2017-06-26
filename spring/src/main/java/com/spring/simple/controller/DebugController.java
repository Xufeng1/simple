package com.spring.simple.controller;

import com.spring.simple.model.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by feng.xu on 2017/5/8.
 */
@Controller
@RequestMapping("/debug")
public class DebugController {

    @RequestMapping("/test")
    @ResponseBody
    public ApiResult<String> test() {
        ApiResult<String> result = new ApiResult<>();
        result.success();
        return result;
    }
}
