package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.TakeLog;

import java.util.List;

/**
 * The interface Take log service.
 */
public interface ITakeLogService extends  IBaseService<TakeLog> {

    /**
     * Find by user id and type list.
     *
     * @param userId the user id
     * @param type   the type
     * @return the list
     * @throws Exception the exception
     */
    List<TakeLog> findByUserIdAndType( Long userId, String type) throws Exception;

    /**
     * Auto take int.
     *
     * @param takeLog the take log
     * @return the int
     * @throws Exception the exception
     */
    int autoTake(TakeLog takeLog) throws Exception;
}
