package com.tu.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Description
 * @Classname Listener
 * @Date 2019/5/23 10:40
 * @Created by tuyongjian
 */
public class Listener {

    private Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?,?> record){
        logger.info("kafka key ---"+record.key());
        logger.info("kafka value ---"+record.value());
    }
}