package com.tu.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description
 * @Classname RedisApplication redis 服务的启动类
 * @Date 2019/4/28 14:05
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }

}