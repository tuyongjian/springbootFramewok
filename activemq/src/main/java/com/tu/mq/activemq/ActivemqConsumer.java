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

    @JmsListener(destination = "tu",containerFactory = "innerFactory")
    public void readmsg(String msg){
        logger.info("activemq接收的消息为--"+msg);
    }
}