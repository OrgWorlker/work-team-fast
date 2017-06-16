package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.IntegralLog;

import java.util.List;

/**
 * The interface Integral log service.
 */
public interface IIntegralLogService extends IBaseService<IntegralLog> {

    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<IntegralLog> findByUserId(Long userId) throws Exception;
}
