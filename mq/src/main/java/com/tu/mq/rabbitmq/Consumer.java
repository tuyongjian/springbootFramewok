package com.tu.mq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消费者
 * @Classname Consumer
 * @Date 2019/5/22 15:31
 * @Created by tuyongjian
 * 监听queue队列的消息
 */
@Component
@RabbitListener(queues = "queue")
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void process(String  message){
        logger.info("消费者接收的消息为{}",message);
    }
}