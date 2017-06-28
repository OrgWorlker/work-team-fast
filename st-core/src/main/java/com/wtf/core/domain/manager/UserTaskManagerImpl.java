package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.UserTask;
import com.wtf.core.interfaces.manager.IUserTaskManager;
import com.wtf.core.interfaces.service.IUserTaskService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * The type User task manager.
 */
@ManagerService
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

    /**
     * Find order by buyer id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    @Override
    public List<UserTask> findOrderByBuyerId(Long userId) throws Exception {
        final UserTask userTask = new UserTask();
        userTask.setBuyerId(userId);
        return this.userTaskService.findAll(userTask);
    }
}
