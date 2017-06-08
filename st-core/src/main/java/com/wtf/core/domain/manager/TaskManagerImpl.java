package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.Task;
import com.wtf.core.domain.model.User;
import com.wtf.core.interfaces.manager.ITaskManager;
import com.wtf.core.interfaces.service.ITaskService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Task manager.
 */
@ManagerService
public class TaskManagerImpl implements ITaskManager {
    /**
     * The Task service.
     */
    @Resource
    private ITaskService taskService;

    @Override
    public List<Task> findByUserId(Long userId) throws Exception {
        final Task task = new Task();
        final User user = new User();
        user.setId(userId);
        task.setUser(user);
        return this.taskService.findAll(task);
    }
}
