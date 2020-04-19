package com.tu.rocketmq.action;

import com.tu.mysql.model.User;
import com.tu.mysql.service.UserService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:
 */
@RestController
@RequestMapping(value = "rocketmq")
public class RocketAction {
    private static final Logger logger = LoggerFactory.getLogger(RocketAction.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private UserService userService;

    @GetMapping(value = "test")
    public void Test() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        User user = new User();
        user.setUserName("ROCKETMQ");
        user.setPassword("123");
        userService.add(user);
        String msg = user.getId().toString();
        logger.info("开始发送消息："+msg);
        Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg,10000);
        logger.info("消息发送响应信息："+sendResult.toString());
    }
}
