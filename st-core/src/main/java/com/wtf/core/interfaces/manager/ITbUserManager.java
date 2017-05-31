package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.model.TbUser;

import java.util.List;

/**
 * The type Tb user manager.
 */
public interface ITbUserManager {
    /**
     * Find tb user num by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<TbUser> findTbUserNumByUserId(Long userId) throws Exception;
}
