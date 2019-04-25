package com.tu.webapp.configura;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tuyongjian on 2019/4/25.
 * 数据库连接池的相关配置，可以配置黑名单等
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statVierServle(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //IP 白名单 如果设置了白名单，那么没有加入白名单的IP都访问不了，没有这只白名单，则都可以访问
        // 如果黑名单里面有的IP 白名单里面也有，那么黑名单的权限大于白名单，
        servletRegistrationBean.addInitParameter("allow","127.0.0.1,192.168.2.221");
        //IP黑名单 都存在是 deny等级大于 allow
        servletRegistrationBean.addInitParameter("deny","192.168.2.221");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","druid");

        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");

        return servletRegistrationBean;
    }

    public FilterRegistrationBean starFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略的过滤规则
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
