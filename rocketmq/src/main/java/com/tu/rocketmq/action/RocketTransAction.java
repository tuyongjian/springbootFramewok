package com.tu.rocketmq.action;

import com.tu.mysql.model.User;
import com.tu.mysql.service.UserService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/20 17:24
 * @Description:
 */
@RestController
@RequestMapping(value = "rocketMqTrans")
public class RocketTransAction {


    private static final Logger logger = LoggerFactory.getLogger(RocketTransAction.class);

    @Autowired
    private TransactionMQProducer transactionMQProducer;



    @GetMapping(value = "test")
    public void Test() throws  MQClientException {

        String msg = "11";//UUID.randomUUID().toString();
        logger.info("开始发送消息："+msg);
        Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
        //默认3秒超时
        TransactionSendResult transactionSendResult = transactionMQProducer.sendMessageInTransaction(sendMsg,10000);
        logger.info("消息发送响应信息："+transactionSendResult.toString());
    }
}
