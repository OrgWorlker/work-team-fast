package com.wtf.core.domain.service;

import com.wtf.core.domain.model.UserTask;
import com.wtf.core.infrastructure.constant.Constant;
import com.wtf.core.interfaces.repository.IUserTaskMapper;
import com.wtf.core.interfaces.service.IUserTaskService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * The type User task service.
 */
@Service
public class UserTaskServiceImpl extends BaseServiceImpl<UserTask, IUserTaskMapper> implements IUserTaskService {

    @Override
    public List<UserTask> findOrderByNullBuyersAndStartTime(Date startTime) throws Exception {
        String dateString = DateFormatUtils.format(startTime, Constant.DATE_FORMAT_PATTERN);
        return this.getMapper().findOrderByNullBuyersAndStartTime(dateString);
    }
}
