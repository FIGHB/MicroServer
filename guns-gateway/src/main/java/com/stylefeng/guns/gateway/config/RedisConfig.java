package com.stylefeng.guns.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

    @Bean
    public Jedis GetJedis(){
        return new Jedis("127.0.0.1",6379);
    }
}
