package com.tu.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description
 * @Classname OauthApplication
 * @Date 2019/7/25 10:31
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class);
    }
}