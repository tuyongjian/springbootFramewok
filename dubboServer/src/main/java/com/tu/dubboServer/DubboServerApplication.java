package com.tu.dubboServer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DubboServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DubboServerApplication.class,args);
    }
}
