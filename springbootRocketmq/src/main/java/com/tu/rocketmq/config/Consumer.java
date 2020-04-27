package com.tu.rocketmq.config;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/21 16:26
 * @Description:消费者
 */
@Component
@RocketMQMessageListener(topic="test",consumerGroup="test" )
public class Consumer implements RocketMQListener<String> {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);


    @Override
    public void onMessage(String s) {
        logger.info("开始消费---"+s);
    }
}
