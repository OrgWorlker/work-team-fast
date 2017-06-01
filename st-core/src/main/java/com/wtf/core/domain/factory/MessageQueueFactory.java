package com.wtf.core.domain.factory;

import com.wtf.infsc.infrastructure.stereotype.Factory;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * The type Message queue factory.
 */
@Factory
public class MessageQueueFactory {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Resource
    private CacheFactory cacheFactory;

    /**
     * Send.
     */
    public void send() {
        this.rabbitTemplate.convertAndSend("hello", "haha");
    }

    /**
     * Send short message.
     *
     * @param phoneNum the phone num
     */
    public void sendShortMessage(String phoneNum) {
        this.rabbitTemplate.convertAndSend("short-message", phoneNum);
    }
}
