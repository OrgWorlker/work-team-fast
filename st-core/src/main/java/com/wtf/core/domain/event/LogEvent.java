package com.wtf.core.domain.event;

import com.alibaba.fastjson.JSON;
import com.wtf.core.domain.model.GoldLog;
import com.wtf.core.domain.model.IntegralLog;
import com.wtf.infsc.infrastructure.stereotype.EventService;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.wtf.infsc.infrastructure.enums.LogEventType.GOLD;
import static com.wtf.infsc.infrastructure.enums.LogEventType.INTEGRAL;

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
    private void sendLogMessage(String jsonStr) {
        this.rabbitTemplate.convertAndSend("log-message", jsonStr);
    }

    /**
     * Send log message.
     *
     * @param goldLog the gold log
     */
    public void sendLogMessage(GoldLog goldLog) {
        final Map<String, Object> context = new HashMap<>();
        context.put("type", GOLD.getType());
        context.put("context", goldLog);
        this.sendLogMessage(JSON.toJSONString(context));
    }

    /**
     * Send log message.
     *
     * @param integralLog the integral log
     */
    public void sendLogMessage(IntegralLog integralLog) {
        final Map<String, Object> context = new HashMap<>();
        context.put("type", INTEGRAL.getType());
        context.put("context", integralLog);
        this.sendLogMessage(JSON.toJSONString(context));
    }
}
