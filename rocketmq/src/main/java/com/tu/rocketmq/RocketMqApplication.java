package com.tu.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/16 15:25
 * @Description:
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RocketMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class,args);
    }
}
