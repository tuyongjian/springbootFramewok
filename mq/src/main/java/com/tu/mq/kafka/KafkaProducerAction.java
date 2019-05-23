package com.tu.mq.kafka;

import com.tu.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname KafkaProducerAction
 * @Date 2019/5/23 10:07
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "kafka")
public class KafkaProducerAction {

    private Logger logger = LoggerFactory.getLogger(KafkaProducerAction.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public Result sendKafkaMessage(){
        String message = "1111";
        kafkaTemplate.send("test","key",message);
        return new Result("200","发送成功");
    }
}