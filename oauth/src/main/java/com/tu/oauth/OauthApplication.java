package com.tu.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description  oauth2的概念可以参考 http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html博客
 * （1） Third-party application：第三方应用程序，client
 *
 * （2）HTTP service：HTTP服务提供商，
 *
 * （3）Resource Owner：资源所有者，本文中又称"用户"（user）。
 *
 * （4）User Agent：用户代理，本文中就是指浏览器。
 *
 * （5）Authorization server：认证服务器，即服务提供商专门用来处理认证的服务器。
 *
 * （6）Resource server：资源服务器，即服务提供商存放用户生成的资源的服务器。它与认证服务器，
 * 可以是同一台服务器，也可以是不同的服务器。
 *
 *
 * 授权码模式（authorization code）
 * 简化模式（implicit）
 * 密码模式（resource owner password credentials）
 * 客户端模式（client credentials）
 *
 *
 *
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