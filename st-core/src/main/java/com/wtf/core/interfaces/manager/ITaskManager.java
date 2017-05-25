package com.wtf.core.interfaces.manager;

import com.wtf.core.domain.model.Task;

import java.util.List;

/**
 * The interface Task manager.
 */
public interface ITaskManager {

    /**
     * Find by user id list.
     *
     * @param userId the user id  卖家ID
     * @return the list
     * @throws Exception the exception
     */
    List<Task> findByUserId(Long userId) throws Exception;
}
