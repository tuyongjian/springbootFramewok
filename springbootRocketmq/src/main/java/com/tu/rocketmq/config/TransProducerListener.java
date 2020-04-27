package com.tu.rocketmq.config;

import com.tu.rocketmq.action.RockerMqAction;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/21 15:36
 * @Description: 事务消息的监听器
 *
 * txProducerGroup 事务生产的监听组
 */
@Component
@RocketMQTransactionListener(txProducerGroup="txProducer")
public class TransProducerListener implements RocketMQLocalTransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransProducerListener.class);

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        logger.info("开始执行事务的本地方法---");
        String jsonString = new String((byte[])message.getPayload());//转换成String
        logger.info("事务的本地方法的消息为---"+jsonString);
        try {
            int i=1/0;
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        logger.info("开始执行事务的本地检查方法---");
        String jsonString = new String((byte[])message.getPayload());//转换成String
        logger.info("事务的本地检查的消息为---"+jsonString);
        return RocketMQLocalTransactionState.COMMIT;
    }
}
