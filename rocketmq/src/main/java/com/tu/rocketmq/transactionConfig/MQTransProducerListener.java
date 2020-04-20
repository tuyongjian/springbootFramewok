package com.tu.rocketmq.transactionConfig;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/20 17:03
 * @Description:生产者的事务监听器
 */
public class MQTransProducerListener implements TransactionListener {

    //执行本地事务
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        return null;
    }

    //检查本地事务
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        return null;
    }
}
