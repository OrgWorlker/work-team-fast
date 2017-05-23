package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.UserTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * The interface User task mapper.
 */
@Mapper
public interface IUserTaskMapper extends BaseMapper<UserTask> {

    /**
     * Find order by null buyers and start time list.
     * 根据当前时间获取未被接单的任务
     * @param startTime the start time
     * @return the list
     * @throws Exception the exception
     */
    List<UserTask> findOrderByNullBuyersAndStartTime(String startTime) throws Exception;
}
