package com.tu.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description 消息启动类
 * @Classname MQApplication
 * @Date 2019/4/28 15:28
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);

    }


}