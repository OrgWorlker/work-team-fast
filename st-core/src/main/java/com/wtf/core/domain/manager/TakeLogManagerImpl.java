package com.wtf.core.domain.manager;

import com.github.pagehelper.PageHelper;
import com.wtf.core.domain.model.TakeLog;
import com.wtf.core.interfaces.manager.ITakeLogManager;
import com.wtf.core.interfaces.service.ITakeLogService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Take log manager.
 */
@ManagerService
public class TakeLogManagerImpl implements ITakeLogManager{
    @Resource
    private ITakeLogService takeLogService;
    /**
     * Find by user id and type list.
     *
     * @param userId   the user id
     * @param type     the type
     * @param pageNum the page num
     * @param pageSize   the page size
     * @return the list
     * @throws Exception the exception
     */
    @Override
    public List<TakeLog> findByUserIdAndType(Long userId, String type, int pageNum, int pageSize) throws Exception {
        if (pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return this.takeLogService.findByUserIdAndType(userId, type) ;
    }
}
