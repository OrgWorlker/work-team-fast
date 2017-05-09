package com.wtf.domain.service;

import com.wtf.domain.model.Task;
import com.wtf.interfaces.repository.ITaskMapper;
import com.wtf.interfaces.service.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Task service.
 */
@Service
@Transactional
public class TaskServiceImpl extends BaseServiceImpl<Task, ITaskMapper> implements ITaskService {

}
