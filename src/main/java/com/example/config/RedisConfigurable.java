package com.example.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis 配置
 * @author: sunshaoping
 * @date: Create by in 09:24 2018-11-20
 */
@Configurable
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class RedisConfigurable {

//    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }
}
