package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.domain.model.UserOrder;

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
     * @throws Exception the exception
     */
    UserLoginDto checkUserNameAndLoginPassword(String userName, String pwd, int comeFrom) throws Exception;

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

    /**
     * Check and update pwd.
     *
     * @param id     the user id
     * @param oldPwd the old pwd
     * @param newPwd the new pwd
     * @param type   the type
     * @return the int
     */
    int checkAndUpdatePwd(Long id, String oldPwd, String newPwd, Integer type);

    /**
     * Update user int.
     *
     * @param user the user
     * @return the int
     * @throws Exception the exception
     */
    int updateUser(User user) throws Exception;

    /**
     * Update pwd by login name int.
     *
     * @param phoneNum the phone num
     * @param checkNum the check num
     * @return the int
     */
    int updatePwdByPhoneName(String phoneNum, String checkNum);

    /**
     * Register int.
     *
     * @param loginName the login name
     * @param qq        the qq
     * @param phoneNum  the phone num
     * @param checknum  the checknum
     * @return the int
     */
    int register(String loginName, String qq, String phoneNum, String checknum);


    /**
     * Find user order by user id user order.
     *
     * @param userId the user id
     * @return the user order
     * @throws Exception the exception
     */
    UserOrder findUserOrderByUserId(Long userId) throws  Exception;
}
