package com.tu.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}