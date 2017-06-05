package com.wtf.core.interfaces.service;


import com.wtf.core.domain.model.User;

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

    /**
     * Find by phone num user.
     *
     * @param phoneNum the phone num
     * @return the user
     */
    User findByPhoneNum(String phoneNum);
}
