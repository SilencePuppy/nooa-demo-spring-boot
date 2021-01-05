package com.hc.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li Xiaobing
 * @Classname RedisProperties
 * @date 2021/1/5 17:42
 */
@Configuration
@Data
public class RedisProperties {
    @Value("${spring.redis.nodes}")
    private String nodes;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;
}
