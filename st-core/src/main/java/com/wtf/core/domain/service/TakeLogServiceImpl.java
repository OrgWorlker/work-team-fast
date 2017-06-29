package com.wtf.core.domain.service;

import com.wtf.core.domain.event.LogEvent;
import com.wtf.core.domain.model.GoldLog;
import com.wtf.core.domain.model.IntegralLog;
import com.wtf.core.domain.model.TakeLog;
import com.wtf.core.domain.model.UserLevel;
import com.wtf.core.interfaces.repository.ITakeLogMapper;
import com.wtf.core.interfaces.service.ITakeLogService;
import com.wtf.core.interfaces.service.IUserLevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * The type Take log service.
 */
@Service
@Transactional
public class TakeLogServiceImpl extends BaseServiceImpl<TakeLog, ITakeLogMapper> implements ITakeLogService {
    @Resource
    private IUserLevelService userLevelService;

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
            final UserLevel userLevel = this.userLevelService.findByUserId(takeLog.getUserId());
            if (takeLog.getType() == 1) {
                final IntegralLog integralLog = new IntegralLog();
                integralLog.setCrtTime(new Date());
                integralLog.setCount(takeLog.getCount() * -1);
                integralLog.setUserId(takeLog.getUserId());
                userLevel.setUsableIntegral(userLevel.getUsableIntegral() - takeLog.getCount());
                this.logEvent.sendLogMessage(integralLog);
            } else if (takeLog.getType() == 0) {
                final GoldLog goldLog = new GoldLog();
                goldLog.setCrtTime(new Date());
                goldLog.setCount(takeLog.getCount() * -1);
                goldLog.setUserId(takeLog.getUserId());
                userLevel.setUsableGold(userLevel.getUsableGold() - takeLog.getCount());
                this.logEvent.sendLogMessage(goldLog);
            }
            this.userLevelService.update(userLevel);
        }
        return update;
    }

}
