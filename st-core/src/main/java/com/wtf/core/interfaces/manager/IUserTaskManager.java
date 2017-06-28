package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.model.UserTask;

import java.util.Date;
import java.util.List;

/**
 * The interface User task manager.
 */
public interface IUserTaskManager {
    /**
     * Find order by null buyer and start time list.
     *
     * @param statrTime the statr time
     * @return the list
     * @throws Exception the exception
     */
    List<UserTask> findOrderByNullBuyerAndStartTime(Date statrTime) throws Exception;

    /**
     * Find order by buyer id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<UserTask> findOrderByBuyerId(Long userId) throws Exception;
}
