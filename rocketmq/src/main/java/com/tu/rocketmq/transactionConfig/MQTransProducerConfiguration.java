package com.tu.rocketmq.transactionConfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/23 16:30
 * @Description:带事务处理的生产者配置
 */
@Configuration
public class MQTransProducerConfiguration {


        public static final Logger LOGGER = LoggerFactory.getLogger(MQTransProducerConfiguration.class);

        @Autowired
        TransactionListener transactionListener;
        /**
         * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
         */
        @Value("${rocketmq.producer.groupName}")
        private String groupName;
            //nameserver地址
        @Value("${rocketmq.producer.namesrvAddr}")
        private String namesrvAddr;
        /**
         * 消息最大大小，默认4M
         */
        @Value("${rocketmq.producer.maxMessageSize}")
        private Integer maxMessageSize ;
        /**
         * 消息发送超时时间，默认3秒
         */
        @Value("${rocketmq.producer.sendMsgTimeout}")
        private Integer sendMsgTimeout;
        /**
         * 消息发送失败重试次数，默认2次
         */
        @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
        private Integer retryTimesWhenSendFailed;

        @Bean
        public TransactionMQProducer getTransRocketMQProducer() throws Exception {
            if (StringUtils.isEmpty(this.groupName)) {
                throw new Exception("groupName is blank");
            }
            if (StringUtils.isEmpty(this.namesrvAddr)) {
                throw new Exception("nameServerAddr is blank");
            }
            //事务消息生产者
            TransactionMQProducer producer = new TransactionMQProducer(this.groupName);
            producer.setNamesrvAddr(this.namesrvAddr);
            //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
            //producer.setInstanceName(instanceName);
            if(this.maxMessageSize!=null){
                producer.setMaxMessageSize(this.maxMessageSize);
            }
            if(this.sendMsgTimeout!=null){
                producer.setSendMsgTimeout(this.sendMsgTimeout);
            }

            //事务的消息生产者参数
            producer.setCheckThreadPoolMinSize(5);    // 事务回查最小并发数
            producer.setCheckThreadPoolMaxSize(20);   // 事务回查最大并发数
            producer.setCheckRequestHoldMax(2000);    // 队列数
            //事务监听器

            producer.setTransactionListener(transactionListener);

            ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("client-transaction-msg-check-thread");
                    return thread;
                }
            });
            //线程池
            producer.setExecutorService(executorService);

            //如果发送消息失败，设置重试次数，默认为2次
            if(this.retryTimesWhenSendFailed!=null){
                producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
            }

            try {
                producer.start();

                LOGGER.info(String.format("生产者事务producer is start ! groupName:[%s],namesrvAddr:[%s]"
                        , this.groupName, this.namesrvAddr));
            } catch (Exception e) {
                LOGGER.error(String.format("producer is error {}"
                        , e.getMessage(),e));
                throw new Exception(e);
            }
            return producer;
        }

}
