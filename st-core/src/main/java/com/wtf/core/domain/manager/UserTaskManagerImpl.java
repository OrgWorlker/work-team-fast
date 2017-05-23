package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.UserTask;
import com.wtf.core.infrastructure.stereotype.Manager;
import com.wtf.core.interfaces.manager.IUserTaskManager;
import com.wtf.core.interfaces.service.IUserTaskService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * The type User task manager.
 */
@Manager
public class UserTaskManagerImpl implements IUserTaskManager {

    @Resource
    private IUserTaskService userTaskService;

    /**
     * Find order by null buyer and start time list.
     *
     * @param statrTime the statr time
     * @return the list
     */
    public List<UserTask> findOrderByNullBuyerAndStartTime(Date statrTime) throws Exception {
        return this.userTaskService.findOrderByNullBuyersAndStartTime(statrTime);
    }
}
