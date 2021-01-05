package com.hc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Li Xiaobing
 * @Classname RedisTest
 * @date 2021/1/5 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void test1() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock_key");
        lock.lock();
        Thread.sleep(1000);
        lock.unlock();


    }
}
