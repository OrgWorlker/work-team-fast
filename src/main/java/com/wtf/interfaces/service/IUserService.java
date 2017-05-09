package com.wtf.interfaces.service;

import com.wtf.domain.model.User;

import java.util.List;


/**
 * The interface User service.
 */
public interface IUserService extends IBaseService<User> {

    /**
     * Find by user name user.
     *
     * @param userName the user name
     * @return the user
     */
    User findByUserName(String userName);

}
