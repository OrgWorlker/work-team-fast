package com.wtf.core.domain.manager;

import com.github.pagehelper.PageHelper;
import com.wtf.core.domain.model.GoldLog;
import com.wtf.core.interfaces.manager.IGoldLogManager;
import com.wtf.core.interfaces.service.IGoldLogService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Take log manager.
 */
@ManagerService
public class GoldLogManagerImpl implements IGoldLogManager {
    @Resource
    private IGoldLogService GoldLogService;

    /**
     * Find by user id and type list.
     *
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     * @throws Exception the exception
     */
    public List<GoldLog> findByUserId(Long userId,  int pageNum, int pageSize) throws Exception {
        if (pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return this.GoldLogService.findByUserId(userId);
    }
}
