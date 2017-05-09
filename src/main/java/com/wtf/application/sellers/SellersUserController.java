package com.wtf.application.sellers;

import com.github.pagehelper.PageHelper;
import com.wtf.domain.dto.UserLoginDto;
import com.wtf.domain.model.User;
import com.wtf.infrastructure.constant.Constant;
import com.wtf.interfaces.manager.IUserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/4.
 */
@Controller
@RequestMapping("sellers/user")
public class SellersUserController {

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
    public List<User> findUserList(User user, @RequestParam int startNum, @RequestParam int pageSize) {
        if (pageSize > 0) {
            PageHelper.startPage(startNum, pageSize);
        }
        return new ArrayList<>();
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
