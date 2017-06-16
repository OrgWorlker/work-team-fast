package com.wtf.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * The type Short message event.
 */
@Slf4j
@Service
@RabbitListener(queues = {"short-message"})
public class ShortMessageEvent {


    /**
     * The String redis template.
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Send short message event.
     *
     * @param context the context
     * @throws Exception the exception
     */
    @RabbitHandler
    public void sendShortMessageEvent(String context) throws Exception {
        final int valicode = (int) ((Math.random() * 9 + 1) * 100000);

        this.stringRedisTemplate.opsForValue().set(context, valicode + "");
        this.stringRedisTemplate.expire(context, 180, TimeUnit.SECONDS);
        final String message = "欢迎使用VIP福利平台，您的验证码为 " + valicode + "，180秒内有效，请勿泄漏！";
        log.debug("{} short-message {}", context, message);
    }
}
