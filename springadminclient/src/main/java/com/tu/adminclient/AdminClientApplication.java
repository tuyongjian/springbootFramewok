package com.tu.adminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by tuyongjian on 2019/4/26.
 * spring ad
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class,args);
    }
}
