package com.tu.mq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 生产者
 * @Classname Product
 * @Date 2019/5/22 15:32
 * @Created by tuyongjian
 */
@Service
public class RabbitProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 向queue队列中发送消息
     * @param msg
     * @return
     */
    public String send(String msg){
        amqpTemplate.convertAndSend("queue",msg);
        return "消息："+msg+"已发送";
    }

}