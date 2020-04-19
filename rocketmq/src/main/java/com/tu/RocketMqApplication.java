package com.tu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: tuyongjian
 * @Date: 2020/4/16 15:25
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = {"com.tu.mysql.dao"})
@EnableTransactionManagement
public class RocketMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class,args);
    }
}
