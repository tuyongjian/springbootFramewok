package com.tu.mq.activemq;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Description
 * @Classname product
 * @Date 2019/6/10 15:39
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "activemq")
public class ActivemqProduct {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "test",method = RequestMethod.POST)
    public void test(@RequestParam(value = "msg")String msg){
        MessageCreator mc = createMsg(msg);
        jmsTemplate.convertAndSend("test",msg);
    }

    @RequestMapping(value = "send",method = RequestMethod.POST)
    public void send(@RequestParam(value = "msg")String msg){
            MessageCreator mc = createMsg(msg);
            jmsTemplate.send(new ActiveMQQueue("tu"),mc);
    }

    public static MessageCreator createMsg(final Object o){
        if (null == o) return null;
        return new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String str;
                if(o instanceof String){
                    str = o.toString();
                }else {
                    str = JSON.toJSONString(o);
                }
                return session.createTextMessage(str);
            }
        };
    }

}