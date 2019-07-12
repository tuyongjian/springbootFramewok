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
public class RabbitConsumer {

    private Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    @RabbitHandler
    @RabbitListener(queues = "queue",containerFactory = "rabbitListenerContainerFactory")
    public void process(String  message){
        logger.info("消费者-1接收的消息为--{}",message);
    }

    @RabbitHandler
    @RabbitListener(queues = "queue",containerFactory = "rabbitListenerContainerFactory")
    public void process1(String  message){
        logger.info("消费者-2接收的消息为--{}",message);
    }

    @RabbitHandler
    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void process2(String  message){
        logger.info("消费者-1接收的消息为--{}",message);
    }

    @RabbitHandler
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void process3(String  message){
        logger.info("消费者-2接收的消息为--{}",message);
    }
}