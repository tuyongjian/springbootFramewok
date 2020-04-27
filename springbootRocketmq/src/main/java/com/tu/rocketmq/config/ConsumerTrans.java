package com.tu.rocketmq.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/21 16:26
 * @Description:事务消费者
 *
 * 当实现 RocketMQPushConsumerLifecycleListener的prepareStart方法之后
 * RocketMQListener 的onMessage方法就不会执行
 *
 */
@Component
@RocketMQMessageListener(topic="testTrans",consumerGroup="testTrans" )
public class ConsumerTrans implements RocketMQListener<String> , RocketMQPushConsumerLifecycleListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTrans.class);


    @Override
    public void onMessage(String s) {
        logger.info("onMessage 开始消费事务消息---"+s);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
        logger.info("prepareStart 开始消费事务消息---");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    MessageExt messageExt = msgs.get(0);
                    logger.info("重试次数:" + messageExt.getReconsumeTimes());
                    // 注意可以在此处判断重试次数，实现入库插入，记录相关消息，进行下面的业务逻辑处理
                    if (messageExt.getReconsumeTimes() >= 3) {
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    int i=1/0;
                    logger.info("接受到的消息:" + new String(messageExt.getBody()));
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                } catch (Exception e) {
                    logger.info("消费出现异常：" + e.getMessage());
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
               }
           });
        }
}
