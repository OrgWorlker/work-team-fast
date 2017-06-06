package com.wtf.buyers.application;

import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.interfaces.manager.IUserManager;
import com.wtf.infsc.infrastructure.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * The type User controller.
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController extends ControllerAdapter {
    @Resource
    private IUserManager userManager;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Pages model and view.
     *
     * @param userId the user id
     * @param money  the money
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("principal-withdrawals/{money}/{userId}")
    public ModelAndView principal(@PathVariable Long userId, @PathVariable Double money , Model model) {
        model.addAttribute("money", money);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/principal-withdrawals");
    }

    /**
     * Fund details model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("fund-details/{userId}")
    public ModelAndView fundDetails(@PathVariable Long userId, Model model) {
        model.addAttribute("user", this.userManager.findById(userId));
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/fund-details");
    }

    /**
     * Cash model and view.
     *
     * @param userId the user id
     * @param money  the money
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("cash-withdrawals/{money}/{userId}")
    public ModelAndView cash(@PathVariable Long userId, @PathVariable Double money , Model model) {
        model.addAttribute("money", money);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/cash-withdrawals");
    }

    /**
     * Bind model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("bind/{userId}")
    public ModelAndView bind(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/bind");

    }

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
    @ResponseBody
    public UserLoginDto login(String username, String checknum, Model model, HttpServletRequest request) throws Exception {
        final UserLoginDto userLoginDto = this.userManager.checkUserNameAndLoginPassword(username, checknum, 2);
        model.addAttribute(Constant.CURRENT_USER, userLoginDto);
        final User user = userLoginDto.getUser();
        if (user != null) {
            request.getSession().setAttribute(Constant.CURRENT_USER, userLoginDto);
            final Long count = user.getCount();
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
     * @param userId the user id
     * @param type   the type 0:LOGIN_PWD, 1:TRAD_PWD
     * @return the string
     */
    @RequestMapping("update/{userId}/{type}")
    @ResponseBody
    public String updateLogin(String oldPwd, String newPwd, @PathVariable Long userId, @PathVariable Integer type) {
        final int resultNum = this.userManager.checkAndUpdatePwd(userId, oldPwd, newPwd, type);
        if (resultNum > 0) {
            return SUCCESS;
        }
        return FAILD;
    }

    /**
     * Retrieve string.
     *
     * @param phoneNum the phone num
     * @param valicode the valicode
     * @param checkNum the check num
     * @return the string
     */
    @PostMapping("retrieve")
    @ResponseBody
    public String retrieve(String phoneNum, String valicode, String checkNum){
        final String realValicode = this.stringRedisTemplate.opsForValue().get(phoneNum);
        if (!valicode.equals(realValicode)) {
            return "ERROR_VALI_CODE";
        }
        final int i = this.userManager.updatePwdByPhoneName(phoneNum, checkNum);
        if (i > 0) {
            return SUCCESS;
        }
        return FAILD;
    }

    /**
     * Register string.
     *
     * @param loginName the login name
     * @param qq        the qq
     * @param phoneNum  the phone num
     * @param checknum  the checknum
     * @return the string
     */
    @PostMapping("register")
    @ResponseBody
    public String register(String loginName, String qq, String phoneNum, String checknum) {
        final int i = this.userManager.register(loginName, qq, phoneNum, checknum);
        return FAILD;
    }
}
