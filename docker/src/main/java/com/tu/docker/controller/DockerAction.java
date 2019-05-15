package com.tu.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname DockerAction
 * @Date 2019/5/15 14:56
 * @Created by tuyongjian
 */
@RestController
public class DockerAction {

    @RequestMapping(value = "hello")
    public String hello(){
        return "Hello World";
    }
}