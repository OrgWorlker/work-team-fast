package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;

import java.util.List;

/**
 * The interface User manager.
 */
public interface IUserManager {

    /**
     * Check user name and password int.
     *
     * @param userName the username
     * @param pwd      the pwd
     * @param comeFrom the come from 手机端2，卖家端1，运营商0, 3是超级管理员
     * @return the int
     */
    UserLoginDto checkUserNameAndLoginPassword(String userName, String pwd, int comeFrom);

    /**
     * Check user trade pwd boolean.
     *
     * @param userId   the user id
     * @param tradePwd the trade pwd
     * @return the boolean  成功：true 失败;false
     */
    boolean checkUserTradePwd(Long userId, String tradePwd);

    /**
     * Find all list.
     *
     * @param user the user
     * @return the list
     */
    List<User> findAll(User user);


    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    User findById(Long id);
}
