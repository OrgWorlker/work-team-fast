package com.wtf.core.domain.service;

import com.alibaba.fastjson.JSON;
import com.wtf.core.domain.event.LogEvent;
import com.wtf.core.domain.model.GoldLog;
import com.wtf.core.domain.model.IntegralLog;
import com.wtf.core.domain.model.TakeLog;
import com.wtf.core.interfaces.repository.ITakeLogMapper;
import com.wtf.core.interfaces.service.ITakeLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Take log service.
 */
@Service
@Transactional
public class TakeLogServiceImpl extends  BaseServiceImpl<TakeLog, ITakeLogMapper> implements ITakeLogService {
    @Resource
    private LogEvent logEvent;
    @Override
    public List<TakeLog> findByUserIdAndType(Long userId, String type) throws Exception {
        return this.getMapper().findByUserIdAndType(userId, type);
    }

    /**
     * Auto take int.
     *
     * @param takeLog the take log
     * @return the int
     * @throws Exception the exception
     */
    @Override
    public int autoTake(TakeLog takeLog) throws Exception {
        final int update = this.getMapper().update(takeLog);
        if (update > 0 && takeLog.getFlag() == 1) {
            final Map<String, Object> context = new HashMap<>();
            if (takeLog.getType() == 1) {
                context.put("type" ,"I");
                final IntegralLog integralLog = new IntegralLog();
                integralLog.setCrtTime(takeLog.getCrtTime());
                integralLog.setCount(takeLog.getCount() * -1);
                integralLog.setUserId(takeLog.getUserId());
                context.put("context", integralLog);
            } else if(takeLog.getType() == 0) {
                context.put("type" ,"G");
                final GoldLog goldLog = new GoldLog();
                goldLog.setCrtTime(takeLog.getCrtTime());
                goldLog.setCount(takeLog.getCount() * -1);
                goldLog.setUserId(takeLog.getUserId());
                context.put("context", goldLog);
            }
            this.logEvent.sendLogMessage(JSON.toJSONString(context));
        }
        return update;
    }

}
