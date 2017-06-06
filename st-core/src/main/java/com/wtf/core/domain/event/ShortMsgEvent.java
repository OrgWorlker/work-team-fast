package com.wtf.core.domain.event;

import com.wtf.infsc.infrastructure.stereotype.FactoryService;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * The type Message queue factory.
 */
@FactoryService
public class ShortMsgEvent {

    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * Send short message.
     *
     * @param phoneNum the phone num
     */
    public void sendShortMessage(String phoneNum) {
        this.rabbitTemplate.convertAndSend("short-message", phoneNum);
    }
}
