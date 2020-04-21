package com.tu.rocketmq.config;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/21 16:26
 * @Description:
 */
@Component
@RocketMQMessageListener(topic="",consumerGroup="")
public class Consumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {

    }
}
