package com.tu.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description springboot admin 监控启动类
 * @Classname com.tu.admin.AdminApplication
 * @Date 2019/4/26 16:19
 * @Created by tuyongjian
 *
 * @EnableAdminServer 开启adminserver监控
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAdminServer
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}