package com.hc.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li Xiaobing
 * @Classname RedissonConfig
 * @date 2021/1/5 17:41
 */
@Configuration
public class RedissonConfig {

    @Autowired
    RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient(){
        Config config =new Config();
        config.useSingleServer().setAddress("redis://"+redisProperties.getNodes());
        return Redisson.create(config);
    }

}
