package com.tu.mq.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Classname consumer
 * @Date 2019/6/10 15:37
 * @Created by tuyongjian
 */
@Service
public class ActivemqConsumer {

    private Logger logger = LoggerFactory.getLogger(ActivemqConsumer.class);

    @JmsListener(destination = "tu",containerFactory = "outFactory")
    public void readmsg(String msg){
        logger.info("activemq接收的消息为--"+msg);
    }

    @JmsListener(destination = "test1",containerFactory = "innerFactory")
    public void test1(String msg){
        logger.info("activemq接收的消息为--"+msg);
    }

    @JmsListener(destination = "test",containerFactory = "innerFactory")
    public void test(String msg){
        logger.info("activemq接收的消息为--"+msg);
    }
}