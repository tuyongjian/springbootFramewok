package com.tu.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description Swagger是一款Restful接口的文档在线自动生成+功能测试的软件。
 * @Classname SwaggerApplication
 * @Date 2019/5/15 16:45
 * @Created by tuyongjian
 *
 * @ComponentScan 添加扫描包
 * 扫描webapp模块下面的包，需要将 webapp模块依赖进来
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.tu.webapp","com.tu.swagger"})
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}