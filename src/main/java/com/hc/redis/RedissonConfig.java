package com.hc.redis;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
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
    private RedisProperties redisProperties;

    private static final String REDIS_CLUSTER_URL_PREFIX = "redis://";

    @Bean
    public RedissonClient redissonClient() {
        String[] nodeStrs = redisProperties.getNodes().split(",");
        for (int i = 0; i < nodeStrs.length; i++) {
            nodeStrs[i] = REDIS_CLUSTER_URL_PREFIX + nodeStrs[i];
        }

        Config config = new Config();
        config.useClusterServers().addNodeAddress(nodeStrs).setScanInterval(2000).setPassword(redisProperties.getPassword());

        RedissonClient redissonClient = Redisson.create(config);
        RAtomicLong lx = redissonClient.getAtomicLong("lx");
        lx.set(1);
        return redissonClient;
    }

}
