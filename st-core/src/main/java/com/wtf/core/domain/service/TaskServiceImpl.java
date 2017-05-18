package com.wtf.core.domain.service;


import com.wtf.core.domain.model.Task;
import com.wtf.core.interfaces.repository.ITaskMapper;
import com.wtf.core.interfaces.service.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Task service.
 */
@Service
@Transactional
public class TaskServiceImpl extends BaseServiceImpl<Task, ITaskMapper> implements ITaskService {

}
