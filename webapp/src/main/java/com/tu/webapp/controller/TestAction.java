package com.tu.webapp.controller;

import com.tu.common.MyException;
import com.tu.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname TestAction
 * @Date 2019/4/19 13:35
 * @Created by tuyongjian
 */
@RestController
public class TestAction {

    @GetMapping("index")
    public String index(){
        return "Hello world";
    }

    @RequestMapping(value = "test")
    public Result test(){
        int i=1/0;
        return new Result();
    }

    @RequestMapping(value = "test1")
    public Result test1(){
       throw new MyException("500","test exception");
    }
}