package com.wtf.core.domain.service;

import com.wtf.core.domain.model.GoldLog;
import com.wtf.core.interfaces.repository.IGoldLogMapper;
import com.wtf.core.interfaces.service.IGoldLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Take log service.
 */
@Service
public class GoldLogServiceImpl extends BaseServiceImpl<GoldLog, IGoldLogMapper> implements IGoldLogService {

    @Override
    public List<GoldLog> findByUserId(Long userId) throws Exception {
        return this.getMapper().findByUserId(userId);
    }
}
