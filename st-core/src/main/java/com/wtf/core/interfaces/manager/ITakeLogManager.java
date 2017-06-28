package com.wtf.core.interfaces.manager;

import com.wtf.core.domain.model.TakeLog;

import java.util.List;

/**
 * The interface Take log manager.
 */
public interface ITakeLogManager {

    /**
     * Find by user id and type list.
     *
     * @param userId   the user id
     * @param type     the type
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     * @throws Exception the exception
     */
    List<TakeLog> findByUserIdAndType(Long userId, String type, int pageNum, int pageSize) throws Exception;

    /**
     * Save int.
     *
     * @param takeLog the take log
     * @return the int
     */
    int save(TakeLog takeLog);
}
