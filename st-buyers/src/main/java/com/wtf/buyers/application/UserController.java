package com.wtf.buyers.application;

import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.infrastructure.constant.Constant;
import com.wtf.core.interfaces.manager.IUserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController extends ControllerAdapter {
    @Resource
    private IUserManager userManager;

    /**
     * Login string.
     * 用户登录的方法，成功返回success，失败返回error
     *
     * @param username the username
     * @param checknum the checknum
     * @param model    the model
     * @param request  the request
     * @return the string
     * @throws Exception the exception
     */
    @RequestMapping("login")
    public UserLoginDto login(String username, String checknum, Model model, HttpServletRequest request) throws Exception {
        final UserLoginDto userLoginDto = this.userManager.checkUserNameAndLoginPassword(username, checknum, 2);
        model.addAttribute(Constant.CURRENT_USER, userLoginDto);
        final User user = userLoginDto.getUser();
        if ( user !=null) {
            request.getSession().setAttribute(Constant.CURRENT_USER, userLoginDto);
            final Long count = user.getCount();
            if (count == 0) {
                userLoginDto.setFlag(2);
            }
            user.setCount(count + 1);
            this.userManager.updateUser(user);
            userLoginDto.clearPwd();
            return userLoginDto;
        }
        return userLoginDto;
    }

    /**
     * Update login string.
     *
     * @param oldPwd the old pwd
     * @param newPwd the new pwd
     * @param type   the type 0:LOGIN_PWD, 1:TRAD_PWD
     * @return the string
     */
    @RequestMapping("update/{userId}/{type}")
    public String updateLogin(String oldPwd, String newPwd, @PathVariable Long userId, @PathVariable Integer type) {
        final int resultNum = this.userManager.checkAndUpdatePwd(userId, oldPwd, newPwd, type);
        if (resultNum > 0) {
            return SUCCESS;
        }
        return FAILD;
    }
}
