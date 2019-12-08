package com.tu.dubboServer;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @EnableDubbo 注解开启dubbo
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDubbo
public class DubboServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DubboServerApplication.class,args);
    }
}
