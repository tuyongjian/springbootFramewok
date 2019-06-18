package com.tu.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description
 * @Classname ApolloApplication
 * @Date 2019/6/18 9:12
 * @Created by tuyongjian
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class,args);
    }
}