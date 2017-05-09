package com.wtf.interfaces.manager;

import com.wtf.domain.dto.UserLoginDto;

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
    UserLoginDto checkUserNameAndLoginPassword(String userName, String pwd , int comeFrom);

    /**
     * Check user trade pwd boolean.
     *
     * @param userId   the user id
     * @param tradePwd the trade pwd
     * @return the boolean  成功：true 失败;false
     */
    boolean checkUserTradePwd(Long userId, String tradePwd);

}
