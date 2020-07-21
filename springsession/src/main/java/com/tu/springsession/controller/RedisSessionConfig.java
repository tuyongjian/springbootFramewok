package com.tu.springsession.controller;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Auther: tuyongjian
 * @Date: 2020/7/21 13:49
 * @Description:使用这个方法可以使spring把session托管到redis
 */
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800)//过期时间30s
@Configuration
public class RedisSessionConfig {

    //让springSession不再执行config命令
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
