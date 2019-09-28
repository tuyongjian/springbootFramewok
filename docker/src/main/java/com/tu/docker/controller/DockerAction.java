package com.tu.docker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(DockerAction.class);

    @RequestMapping(value = "hello")
    public String hello()
    {
        logger.info("-------------------------");
        return "Hello World !!!";
    }
}