package com.tu.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootRocketMqApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringbootRocketMqApplication.class,args);
    }
}
