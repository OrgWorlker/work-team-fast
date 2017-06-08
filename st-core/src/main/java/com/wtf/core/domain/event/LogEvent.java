package com.wtf.core.domain.event;

import com.wtf.infsc.infrastructure.stereotype.EventService;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * The type Log event.
 */
@EventService
public class LogEvent {

    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * Send short message.
     *
     * @param jsonStr the json str
     */
    public void sendLogMessage(String jsonStr) {
        this.rabbitTemplate.convertAndSend("log-message", jsonStr);
    }
}
