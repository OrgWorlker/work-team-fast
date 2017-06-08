package com.wtf.core.domain.manager;

import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.domain.model.UserInfo;
import com.wtf.core.domain.model.UserLevel;
import com.wtf.core.domain.model.UserOrder;
import com.wtf.core.interfaces.manager.IUserManager;
import com.wtf.core.interfaces.service.IUserInfoService;
import com.wtf.core.interfaces.service.IUserLevelService;
import com.wtf.core.interfaces.service.IUserOrderService;
import com.wtf.core.interfaces.service.IUserService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;
import com.wtf.infsc.infrastructure.util.MD5Util;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * The type User manager.
 */
@ManagerService
@Transactional
public class UserManagerImpl implements IUserManager {

    @Resource
    private IUserService userService;

    @Resource
    private IUserInfoService userInfoService;
    @Resource
    private IUserLevelService userLevelService;
    @Resource
    private IUserOrderService userOrderService;

    /**
     * Check user name and password int.
     *
     * @param userName the username
     * @param pwd      the pwd
     * @param comeFrom the come from 手机端2，卖家端1，运营商0, 3是超级管理员
     * @return the int
     */
    @Override
    public UserLoginDto checkUserNameAndLoginPassword(String userName, String pwd, int comeFrom) throws Exception {
        //根据userName获取user信息
        final User user = this.userService.findByUserName(userName);
        //对传入的pwd进行MD5加密
        final String md5pwd = MD5Util.md5Encode(pwd);
        if (user == null || (user.getComeFrom() != comeFrom && user.getComeFrom() != 3)) {
            return new UserLoginDto(0, "用户不存在");
        } else if (user.getLoginPwd().equals(md5pwd)) {
            return new UserLoginDto(1, "登陆成功", user);
        }
        return new UserLoginDto(0, "用户密码错误"); // 密码错误
    }

    @Override
    public boolean checkUserTradePwd(Long userId, String tradePwd) {
        //根据userId获取user信息
        final User user = this.userService.findById(userId);
        //对传入的tradePwd进行MD5加密
        final String tradPwdMd5 = MD5Util.md5Encode(tradePwd);
        //对加密串与用户信息中的交易密码进行比较，并返回
        return user != null && user.getTradePwd().equals(tradPwdMd5);
    }

    @Override
    public List<User> findAll(User user) {
        return this.userService.findAll(user);
    }

    @Override
    public User findById(Long id) {
        return this.userService.findById(id);
    }

    @Override
    public int checkAndUpdatePwd(Long id, String oldPwd, String newPwd, Integer type) {
        final User user = this.userService.findById(id);
        if (type == 0) {
            if (!MD5Util.md5Encode(oldPwd).equals(user.getLoginPwd())) {
                return -1;
            }
            user.setLoginPwd(newPwd);
        } else if (type == 1) {
            if (!MD5Util.md5Encode(oldPwd).equals(user.getLoginPwd())) {
                return -1;
            }
            user.setTradePwd(newPwd);
        }
        return this.userService.update(user);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return this.userService.update(user);
    }

    /**
     * Update pwd by login name int.
     *
     * @param phoneNum the phone num
     * @param checkNum the check num
     * @return the int
     */
    @Override
    public int updatePwdByPhoneName(String phoneNum, String checkNum) {
        final User user = this.userService.findByPhoneNum(phoneNum);
        user.setLoginPwd(MD5Util.md5Encode(checkNum));
        return this.userService.update(user);
    }

    /**
     * Register int.
     *
     * @param loginName the login name
     * @param qq        the qq
     * @param phoneNum  the phone num
     * @param checknum  the checknum
     * @return the int
     */
    @Override
    public int register(String loginName, String qq, String phoneNum, String checknum) {
        final Date date = new Date();
        final User user = new User();
        final UserInfo userInfo = new UserInfo();
        final UserLevel userLevel = new UserLevel();
        userInfo.setQq(qq);
        userInfo.setTelphone(phoneNum);
        userInfo.setCrtTime(date);
        userInfo.setUpdTime(date);
        this.userInfoService.insert(userInfo);
        userLevel.setCrtTime(date);
        userLevel.setUpdTime(date);
        userLevel.setVip(1);
        this.userLevelService.insert(userLevel);
        user.setUserInfo(userInfo);
        user.setUserLevel(userLevel);
        user.setLoginName(loginName);
        user.setLoginPwd(checknum);

        return this.userService.insert(user);
    }

    /**
     * Find user order by user id user order.
     *
     * @param userId the user id
     * @return the user order
     * @throws Exception the exception
     */
    @Override
    public UserOrder findUserOrderByUserId(Long userId) throws Exception {
        return this.userOrderService.findByUserId(userId);
    }
}
