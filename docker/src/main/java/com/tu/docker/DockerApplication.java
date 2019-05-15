package com.tu.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description
 * @Classname docker
 * @Date 2019/5/15 14:51
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class,args);
    }
}