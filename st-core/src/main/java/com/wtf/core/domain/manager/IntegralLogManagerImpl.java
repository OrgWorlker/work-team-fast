package com.wtf.core.domain.manager;

import com.github.pagehelper.PageHelper;
import com.wtf.core.domain.model.IntegralLog;
import com.wtf.core.interfaces.manager.IIntegralLogManager;
import com.wtf.core.interfaces.service.IIntegralLogService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Take log manager.
 */
@ManagerService
public class IntegralLogManagerImpl implements IIntegralLogManager {
    @Resource
    private IIntegralLogService integralLogService;
    /**
     * Find by user id and type list.
     *
     * @param userId   the user id
     * @param pageNum the page num
     * @param pageSize   the page size
     * @return the list
     * @throws Exception the exception
     */
    @Override
    public List<IntegralLog> findByUserId(Long userId, int pageNum, int pageSize) throws Exception {
        if (pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return this.integralLogService.findByUserId(userId) ;
    }
}
