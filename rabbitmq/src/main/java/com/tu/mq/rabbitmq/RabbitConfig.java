package com.tu.mq.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Classname RabbitConfig
 * @Date 2019/7/11 14:52
 * @Created by tuyongjian
 */
@Configuration
public class RabbitConfig {


    /**
     * 定义一个queue的队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("queue");
    }

    /**
     * 广播交换器 只要是把队列绑定到交换器上，然后发布消息的时候，交换器会把消息
     * 推送到相应的队列上面
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout-exchange");
    }

    //定义二个队列
    @Bean
    public Queue autoDeleteQueue0(){
        return new AnonymousQueue();
    }
    @Bean
    public Queue autoDeleteQueue1(){
        return new AnonymousQueue();
    }

    //把队列绑定到交换器
    @Bean
    public Binding binding0(FanoutExchange fanoutExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(fanoutExchange);
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(fanoutExchange);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}