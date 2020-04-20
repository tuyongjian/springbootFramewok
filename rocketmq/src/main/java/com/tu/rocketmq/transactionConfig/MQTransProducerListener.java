package com.tu.rocketmq.transactionConfig;

import com.tu.mysql.model.User;
import com.tu.mysql.service.UserService;
import com.tu.rocketmq.action.RocketTransAction;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/20 17:03
 * @Description:生产者的事务监听器
 */
@Service
public class MQTransProducerListener implements TransactionListener  {

    private static final Logger logger = LoggerFactory.getLogger(MQTransProducerListener.class);

    @Autowired
    private UserService userService;

    //执行本地事务
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        logger.info("开始执行本地事务。。。");
        String body = new String(message.getBody());
        String key = message.getKeys();
        String transactionId = message.getTransactionId();
        logger.info("transactionId="+transactionId+", key="+key+", body="+body);
        int status = Integer.parseInt(o.toString());
        logger.info("state-------------:"+status);
        try {
                User user = new User();
                String msgBody = null;
                msgBody   = new String(message.getBody(), RemotingHelper.DEFAULT_CHARSET);
                user.setUserName(msgBody);
                user.setPassword("123");
                userService.add(user);
                return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            logger.info("出现异常"+e.getMessage());
            return  LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }

    //检查本地事务

    /**
     * 当本地事务处理返回UNKNOW的时候
     * 回执行次方法进行会查，这个时候再进行
     * 提交消息或者回滚消息
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        logger.info("开始检查本地事务。。。");

        return LocalTransactionState.UNKNOW;
    }
}
