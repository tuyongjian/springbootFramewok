package com.tu.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/*
 * @Description
 * @Classname ActiveMqConfig
 * @Date 2019/6/19 14:42
 * @Created by tuyongjian*/


@Configuration
public class ActiveMqConfig {


    @Value("${spring.inner.activemq.MaxConnections}")
    private int maxConnections;

    @Value("${spring.inner.activemq.IdleTimeout}")
    private int idleTimeout;

    @Value("${spring.inner.activemq.ExpiryTimeout}")
    private int expiryTimeout;

    @Value("${spring.inner.activemq.SessionAcknowledgeMode}")
    private int sessionAcknowledgeMode;

    @Value("${spring.out.activemq.MaxConnections}")
    private int maxConnections1;

    @Value("${spring.out.activemq.IdleTimeout}")
    private int idleTimeout1;

    @Value("${spring.out.activemq.ExpiryTimeout}")
    private int expiryTimeout1;

    @Value("${spring.out.activemq.SessionAcknowledgeMode}")
    private int sessionAcknowledgeMode1;


    @Bean(name = "innerConnectionFactory")
    @Primary
    public PooledConnectionFactory firstConnectionFactory(
            @Value("${spring.inner.activemq.brokerUrl}") String brokerUrl,
            @Value("${spring.inner.activemq.user}") String username,
            @Value("${spring.inner.activemq.password}") String password) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setUserName(username);
        factory.setPassword(password);

        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(factory);
        pooledConnectionFactory.setMaxConnections(maxConnections);
        pooledConnectionFactory.setIdleTimeout(idleTimeout);
        pooledConnectionFactory.setExpiryTimeout(expiryTimeout);
        return pooledConnectionFactory;
    }

    @Bean(name = "innerFactory")
    public JmsListenerContainerFactory innerFactory(
            @Qualifier("innerConnectionFactory") PooledConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSessionAcknowledgeMode(sessionAcknowledgeMode);
        return factory;
    }

    @Bean(name = "outConnectionFactory")
    public PooledConnectionFactory secondConnectionFactory(
            @Value("${spring.out.activemq.brokerUrl}") String brokerUrl,
            @Value("${spring.out.activemq.user}") String username,
            @Value("${spring.out.activemq.password}") String password) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setUserName(username);
        factory.setPassword(password);

        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(factory);
        pooledConnectionFactory.setMaxConnections(maxConnections1);
        pooledConnectionFactory.setIdleTimeout(idleTimeout1);
        pooledConnectionFactory.setExpiryTimeout(expiryTimeout1);
        return pooledConnectionFactory;
    }

    @Bean(name = "outFactory")
    public JmsListenerContainerFactory outFactory(
            @Qualifier("outConnectionFactory") PooledConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSessionAcknowledgeMode(sessionAcknowledgeMode1);
        return factory;
    }

    @Bean(name = "firstJmsTemplate")
    @Primary
    public JmsTemplate getFirstJmsTemplate(@Qualifier("innerConnectionFactory") ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        return template;
    }


    @Bean(name = "secondJmsTemplate")
    public JmsTemplate getSecondJmsTemplate(@Qualifier("outConnectionFactory") ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        return template;
    }

}
