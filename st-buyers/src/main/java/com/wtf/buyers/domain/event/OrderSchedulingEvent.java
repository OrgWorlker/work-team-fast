package com.wtf.buyers.domain.event;

import com.wtf.infsc.infrastructure.stereotype.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Slf4j
@EventService
public class OrderSchedulingEvent {

    private static final String key = "AUTO_ORDER";
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron = "0/1 * * * * ?")
    public void executeFileDownLoadTask() {
//        RandomStringUtils.random(100);
//        this.redisTemplate.opsForList().leftPush(key, "1");
//        this.redisTemplate.opsForList().leftPush(key, "2");
//        this.redisTemplate.opsForList().leftPush(key, "3");
        final Object userId = this.redisTemplate.opsForList().rightPop(key);
        if (userId != null) {
            System.out.println(userId.toString());
        }
    }

}
