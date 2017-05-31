package com.wtf.core.domain.factory;

import com.wtf.core.infrastructure.stereotype.Factory;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * The type Cache factory.
 */
@Factory
public class CacheFactory {


    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * Gets cache.
     *
     * @param key the key
     * @return the cache
     */
    public String getCache(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

}
