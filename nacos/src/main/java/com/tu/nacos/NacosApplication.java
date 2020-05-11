package com.tu.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *  nacos
 *
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@NacosPropertySource(dataId = "nacos-demo",groupId = "nacos-group",autoRefreshed = true)
public class NacosApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(NacosApplication.class,args);
    }


}
