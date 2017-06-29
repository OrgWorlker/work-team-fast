package com.wtf.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wtf.event.infrastructure.model.GoldLog;
import com.wtf.event.infrastructure.model.IntegralLog;
import com.wtf.event.infrastructure.repository.IGoldLogMapper;
import com.wtf.event.infrastructure.repository.IIntegralLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.wtf.infsc.infrastructure.enums.LogEventType.GOLD;
import static com.wtf.infsc.infrastructure.enums.LogEventType.INTEGRAL;

/**
 * The type Log message event.
 */
@Slf4j
@Service
@RabbitListener(queues = {"log-message"})
public class LogMessageEvent {
    /**
     * The Gold log mapper.
     */
    @Resource
    private IGoldLogMapper goldLogMapper;
    /**
     * The Integral log mapper.
     */
    @Resource
    private IIntegralLogMapper integralLogMapper;

    /**
     * Log.
     *
     * @param json the json
     * @throws Exception the exception
     */
    @RabbitHandler
    public void log(String json) throws Exception {
        final JSONObject jsonObject = JSON.parseObject(json);
        final String type = jsonObject.getString("type");
        final String context = jsonObject.getString("context");
        System.out.println(json);
        if (type.equals(GOLD.getType()) ) {
            final GoldLog goldLog = JSON.parseObject(context, GoldLog.class);
            this.goldLogMapper.insert(goldLog);
        }
        if (type.equals(INTEGRAL.getType())) {
            final IntegralLog integralLog = JSON.parseObject(context, IntegralLog.class);
            this.integralLogMapper.insert(integralLog);
        }
    }

}
