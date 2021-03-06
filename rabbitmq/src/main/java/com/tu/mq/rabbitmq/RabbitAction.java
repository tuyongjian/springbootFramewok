package com.tu.mq.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname RabbitAction
 * @Date 2019/5/22 16:58
 * @Created by tuyongjian
 */
@RestController
public class RabbitAction {

    @Autowired
    RabbitProducer producer;

    @RequestMapping(value = "test",method = RequestMethod.POST)
    public void test(@RequestParam(value = "msg")String msg){
        producer.send(msg);
    }


    @RequestMapping(value = "test1",method = RequestMethod.POST)
    public void test1(@RequestParam(value = "msg")String msg){
        producer.send1(msg);
    }
}