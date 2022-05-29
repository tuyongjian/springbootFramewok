package com.tu.redis.controller;

import com.tu.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Classname RedisTestAction
 * @Date 2019/4/28 14:28
 * @Created by tuyongjian
 */
@RestController
public class RedisTestAction {

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @GetMapping(value = "/test")
    public String test(){
        redisUtil.set("test","adfafa");
        return redisUtil.get("test").toString();
    }

    @GetMapping("index")
    public String index(){
        return "Hello world";
    }

}