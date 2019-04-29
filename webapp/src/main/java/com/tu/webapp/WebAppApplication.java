package com.tu.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Classname SpringBootApplication
 * @Date 2019/4/19 11:28
 * @Created by tuyongjian
 *
 * 还没有配置数据库连接时候，启动报以下错误，
 * Failed to configure a DataSource: 'url'
 * attribute is not specified and no embedded datasource could be configured.
 *
 * 添加exclude={DataSourceAutoConfiguration.class} 即可启动成功
 *
 */


@SpringBootApplication
public class WebAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebAppApplication.class,args);

    }
}