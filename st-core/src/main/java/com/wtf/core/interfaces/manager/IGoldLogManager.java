package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.model.GoldLog;

import java.util.List;

/**
 * The interface Gold log manager.
 */
public interface IGoldLogManager {

    /**
     * Find by user id list.
     *
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     * @throws Exception the exception
     */
    List<GoldLog> findByUserId(Long userId, int pageNum, int pageSize) throws Exception;
}
