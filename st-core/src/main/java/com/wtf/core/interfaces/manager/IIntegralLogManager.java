package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.model.IntegralLog;

import java.util.List;

/**
 * The interface Integral log manager.
 */
public interface IIntegralLogManager {
    /**
     * Find by user id list.
     *
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     * @throws Exception the exception
     */
    List<IntegralLog> findByUserId(Long userId, int pageNum, int pageSize) throws Exception;
}
