package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.UserTask;

import java.util.Date;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/18.
 */
public interface IUserTaskService extends IBaseService<UserTask> {

    /**
     * Find order by null buyers and start time list.
     * 根据当前时间获取未被接单的任务
     * @param startTime the start time
     * @return the list
     * @throws Exception the exception
     */
    List<UserTask> findOrderByNullBuyersAndStartTime(Date startTime) throws Exception;
}
