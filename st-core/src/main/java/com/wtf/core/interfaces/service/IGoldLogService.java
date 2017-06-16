package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.GoldLog;

import java.util.List;

/**
 * The interface Gold log service.
 */
public interface IGoldLogService extends IBaseService<GoldLog> {
    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<GoldLog> findByUserId(Long userId) throws Exception;
}
