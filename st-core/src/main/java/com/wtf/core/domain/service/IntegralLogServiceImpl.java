package com.wtf.core.domain.service;

import com.wtf.core.domain.model.IntegralLog;
import com.wtf.core.interfaces.repository.IIntegralLogMapper;
import com.wtf.core.interfaces.service.IIntegralLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Take log service.
 */
@Service
public class IntegralLogServiceImpl extends  BaseServiceImpl<IntegralLog, IIntegralLogMapper> implements IIntegralLogService {


    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    @Override
    public List<IntegralLog> findByUserId(Long userId) throws Exception {
        return this.getMapper().findByUserId(userId);
    }
}
