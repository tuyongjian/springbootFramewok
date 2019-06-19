package com.tu.mq.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description
 * @Classname SenderConf
 * @Date 2019/5/22 15:05
 * @Created by tuyongjian
 */
@Configuration
public class SenderConf {

    /**
     * 定义一个queue的队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("queue");
    }
}