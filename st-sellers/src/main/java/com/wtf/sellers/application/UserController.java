package com.wtf.sellers.application;

import com.github.pagehelper.PageHelper;
import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.infrastructure.constant.Constant;
import com.wtf.core.interfaces.manager.IUserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/4.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserManager userManager;

    /**
     * Find user list list.
     *
     * @param user     the user
     * @param startNum the start num
     * @param pageSize the page size
     * @return the list
     */
    @GetMapping("list")
    @ResponseBody
    public List<User> findUserList(User user, Integer startNum, Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            PageHelper.startPage(startNum, pageSize);
        }
        return this.userManager.findAll( user);
    }

    @GetMapping("login")
    public String login(String username, String checknum, Model model, HttpServletRequest request) {
        final UserLoginDto userLoginDto = this.userManager.checkUserNameAndLoginPassword(username, checknum, 1);
        if (userLoginDto != null) {
            userLoginDto.clearPwd();
            request.getSession().setAttribute(Constant.CURRENT_USER, userLoginDto);
        }
        model.addAttribute(Constant.CURRENT_USER, userLoginDto);
        return "hello";
    }

}
