package com.tu.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 * @Description
 * @Classname ActiveMqConfig
 * @Date 2019/6/19 14:42
 * @Created by tuyongjian
 */
@Configuration
public class ActiveMqConfig {

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
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(
                factory);
        pooledConnectionFactory.setMaximumActiveSessionPerConnection(10);
        pooledConnectionFactory.setMaxConnections(10);
        pooledConnectionFactory.setIdleTimeout(3000);
        pooledConnectionFactory.setExpiryTimeout(1000);
        return pooledConnectionFactory;
    }

    @Bean(name = "innerFactory")
    public JmsListenerContainerFactory innerFactory(
            @Qualifier("innerConnectionFactory") PooledConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;

    }
  /*  @Autowired
    private PooledConnectionFactory connectionFactory;


    @Bean(name = "queueListenerFactory")
    public DefaultJmsListenerContainerFactory queueListenerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
//        factory.setMessageConverter(new SimpleMessageConverter());
        return factory;
    }*/

}