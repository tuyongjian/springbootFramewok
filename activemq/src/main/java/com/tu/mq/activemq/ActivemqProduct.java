package com.tu.mq.activemq;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping(value = "send",method = RequestMethod.POST)
    public void send(@RequestParam(value = "msg")String msg){

        MessageCreator mc = createMsg(msg);
        int defaultPriority = jmsTemplate.getPriority();
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setPriority(1);
        jmsTemplate.send(new ActiveMQQueue("tu"),mc);
        //还原
        jmsTemplate.setPriority(defaultPriority);
        jmsTemplate.setExplicitQosEnabled(false);
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