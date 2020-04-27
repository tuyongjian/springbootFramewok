package com.tu.rocketmq.action;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/27 09:30
 * @Description:
 */

@RestController
@RequestMapping(value = "rocket")
public class RockerMqAction {

    private static final Logger logger = LoggerFactory.getLogger(RockerMqAction.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping(value = "sengMsg")
    public void sendMsg(@RequestParam(value = "topic")String topic,
                        @RequestParam(value = "msg")String msg){
        logger.info("开始发送消息-----");
        rocketMQTemplate.convertAndSend(topic,msg);
    }

    @GetMapping(value = "sengTransMsg")
    public void sengTransMsg(@RequestParam(value = "topic")String topic,
                        @RequestParam(value = "msg")String msg){
        logger.info("开始发送消息-----");
        Message<String> message = MessageBuilder.withPayload(msg).build();
        TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction("txProducer",topic,message,null);
        logger.info("发送消息结果为-----"+transactionSendResult);
    }
}
