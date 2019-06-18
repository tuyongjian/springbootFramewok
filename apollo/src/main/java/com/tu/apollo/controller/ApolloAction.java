package com.tu.apollo.controller;

import com.tu.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname ApolloAction
 * @Date 2019/6/18 9:20
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "apollo")
public class ApolloAction {


    @Value("${msg}")
    private String msg;

    @RequestMapping(value = "index")
    public Result index(){
        return new Result("200",msg);
    }
}