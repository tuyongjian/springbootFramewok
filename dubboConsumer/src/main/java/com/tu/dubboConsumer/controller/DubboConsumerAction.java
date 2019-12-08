package com.tu.dubboConsumer.controller;

import com.tu.dubboConsumer.service.IDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tuyongjian
 * @Date: 2019/12/6 10:06
 * @Description:
 */
@RestController
@RequestMapping(value = "dubboConsumer")
public class DubboConsumerAction {


    @Autowired
    IDubboConsumerService dubboConsumerService;

    @RequestMapping(value = "getCost",method = {RequestMethod.GET,RequestMethod.POST})
    public String getCost(@RequestParam(value = "cost")Integer cost){
        return dubboConsumerService.cost(cost);
    }
}
