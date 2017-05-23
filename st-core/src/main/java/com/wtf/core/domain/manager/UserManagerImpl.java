package com.wtf.core.domain.manager;

import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.infrastructure.stereotype.Manager;
import com.wtf.core.infrastructure.util.MD5Util;
import com.wtf.core.interfaces.manager.IUserManager;
import com.wtf.core.interfaces.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type User manager.
 */
@Manager
public class UserManagerImpl implements IUserManager {

    @Resource
    private IUserService userService;

    /**
     * Check user name and password int.
     *
     * @param userName the username
     * @param pwd      the pwd
     * @param comeFrom the come from 手机端2，卖家端1，运营商0, 3是超级管理员
     * @return the int
     */
    @Override
    public UserLoginDto checkUserNameAndLoginPassword(String userName, String pwd, int comeFrom) {
        //根据userName获取user信息
        final User user = this.userService.findByUserName(userName);
        //对传入的pwd进行MD5加密
        final String md5pwd = MD5Util.md5Encode(pwd);
        if (user == null || (user.getComeFrom() != comeFrom && user.getComeFrom() != 3)) {
            return new UserLoginDto(0, "用户不存在");
        } else if (user.getLoginPwd().equals(md5pwd)){
            return  new UserLoginDto(1, "操作成功", user);
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
}
