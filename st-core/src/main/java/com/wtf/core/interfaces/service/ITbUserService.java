package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.TbUser;

import java.util.List;


/**
 * The interface Tb user service.
 */
public interface ITbUserService extends IBaseService<TbUser> {

    /**
     * Find tb user num by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<TbUser> findTbUserNumByUserId(Long userId) throws Exception;
}
