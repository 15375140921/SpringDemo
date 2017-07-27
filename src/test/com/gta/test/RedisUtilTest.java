package com.gta.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Redis 测试类
 * Created by ningning.jiang on 2017/7/3.
 */
public class RedisUtilTest extends BaseTest {

    Logger logger = Logger.getLogger(RedisUtilTest.class);

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    @Test
    public void testRedisGet() {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set("aa", "123");
        Object value = operations.get("cc");
        logger.info("Value: " + value);
    }

}
