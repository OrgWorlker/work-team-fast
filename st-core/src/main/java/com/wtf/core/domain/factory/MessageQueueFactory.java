package com.wtf.core.domain.factory;

import com.wtf.core.infrastructure.stereotype.Factory;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * The type Message queue factory.
 */
@Factory
public class MessageQueueFactory {

    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * Send.
     */
    public void send() {
        this.rabbitTemplate.convertAndSend("hello", "haha");
    }
}
