package com.wtf.event;

import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RabbitListener(queues = {"short-message"})
public class ShortMessageEvent {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RabbitHandler
    public void sendShortMessageEvent(String context) throws Exception {
        final int valicode = (int) ((Math.random() * 9 + 1) * 100000);

        this.stringRedisTemplate.opsForValue().set(context, valicode + "");
        this.stringRedisTemplate.expire(context, 30, TimeUnit.SECONDS);
        final String message = StringFormatter.format("欢迎使用VIP福利平台，您的验证码为%s，180秒内有效，请勿泄漏！", valicode).getValue();
        log.debug("st-event short-message {}", message);
        log.debug("st-event short-valicode {}", this.stringRedisTemplate.opsForValue().get(context));
    }
}
