package com.tu.oauth.config;

import com.tu.oauth.authentication.MyAuthenticationFailHandler;
import com.tu.oauth.authentication.MyAuthenticationSuccessHandler;
import com.tu.oauth.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description Security 配置类
 * @Classname BrowserSecurityConfig
 * @Date 2019/7/25 10:56
 * @Created by tuyongjian
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 注入 自定义的  登录成功处理类
     */
    @Autowired
    private MyAuthenticationSuccessHandler mySuccessHandler;

    /**
     * 注入 自定义的  登录失败处理类
     */
    @Autowired
    private MyAuthenticationFailHandler myFailHandler;

    /**
     * 重写PasswordEncoder  接口中的方法，实例化加密策略
     * @return 返回 BCrypt 加密策略
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String redirectUrl = securityProperties.getBrowser().getLoginPage();
        //basic 登录方式
//      http.httpBasic()

        //表单登录 方式
        http.formLogin()
                .loginPage("/authentication/require")
                //登录需要经过的url请求
                .loginProcessingUrl("/authentication/form")
                .successHandler(mySuccessHandler)
                .failureHandler(myFailHandler)
                .and()
                //请求授权
                .authorizeRequests()
                //不需要权限认证的url
                .antMatchers("/authentication/require",redirectUrl).permitAll()
                //任何请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                .and()
                //关闭跨站请求防护
                .csrf().disable();
    }


}