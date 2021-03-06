package com.wtf.buyers.application;

import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.TbUser;
import com.wtf.core.domain.model.User;
import com.wtf.core.domain.model.UserBank;
import com.wtf.core.domain.model.UserInfo;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.interfaces.manager.*;
import com.wtf.infsc.infrastructure.configure.FileServerConfigure;
import com.wtf.infsc.infrastructure.constant.Constant;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController extends ControllerAdapter {
    @Resource
    private IUserManager userManager;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private FileServerConfigure fileServerConfigure;
    @Resource
    private IGoldLogManager goldLogManager;
    @Resource
    private IIntegralLogManager integralLogManager;
    @Resource
    private ITakeLogManager takeLogManager;
    @Resource
    private ITbUserManager tbUserManager;

    /**
     * User center model and view.
     *
     * @param model  the model
     * @param userId the user id
     * @return the model and view
     */
    @GetMapping("withdrawals/{userId}")
    public ModelAndView userWith(Model model, @PathVariable Long userId) {
        final User user = this.userManager.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/withdrawals");
    }

    /**
     * Pages model and view.
     *
     * @param userId the user id
     * @param money  the money
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("principal-withdrawals/{money}/{userId}")
    public ModelAndView principal(@PathVariable Long userId, @PathVariable Double money, Model model) {
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
    public ModelAndView cash(@PathVariable Long userId, @PathVariable Double money, Model model) {
        model.addAttribute("money", money);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/cash-withdrawals");
    }

    /**
     * Gold log view model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("gold-log/{userId}")
    @SneakyThrows
    public ModelAndView goldLogView(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("list", this.goldLogManager.findByUserId(userId, 0, 0));
        return new ModelAndView("buyers/user/gold-log");
    }

    /**
     * Gold log view model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     * @throws Exception the exception
     */
    @GetMapping("integral-log/{userId}")
    public ModelAndView integralLogView(@PathVariable Long userId, Model model) throws Exception {
        model.addAttribute("userId", userId);
        model.addAttribute("list", this.integralLogManager.findByUserId(userId, 0, 0));
        return new ModelAndView("buyers/user/integral-log");
    }

    /**
     * Logout model and view.
     *
     * @param request the request
     * @return the model and view
     */
    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.CURRENT_USER);
        return new ModelAndView("buyers/login");
    }

    /**
     * Take gold money model and view.
     *
     * @param gold   the gold
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("take-gold/{gold}/{userId}")
    public ModelAndView takeGoldMoney(@PathVariable Double gold, @PathVariable Long userId, Model model) {
        model.addAttribute("gold", gold);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/take-gold");
    }

    /**
     * Take integral money model and view.
     *
     * @param integral the integral
     * @param userId   the user id
     * @param model    the model
     * @return the model and view
     */
    @GetMapping("take-integral/{integral}/{userId}")
    public ModelAndView takeIntegralMoney(@PathVariable Double integral, @PathVariable Long userId, Model model) {
        model.addAttribute("integral", integral);
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/take-integral");
    }

    /**
     * Take log view model and view.
     *
     * @param userId the user id
     * @param type   the type
     * @param model  the model
     * @return the model and view
     * @throws Exception the exception
     */
    @GetMapping("take-log/{userId}/{type}")
    public ModelAndView takeLogView(@PathVariable Long userId, @PathVariable String type, Model model) throws Exception {
        model.addAttribute("userId", userId);
        model.addAttribute("list", this.takeLogManager.findByUserIdAndType(userId, type, 0, 0));
        return new ModelAndView("buyers/user/take-log");
    }

    /**
     * Cash model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("info/{userId}")
    public ModelAndView userInfo(@PathVariable Long userId, Model model) {
        model.addAttribute("user", this.userManager.findById(userId));
        model.addAttribute("userId", userId);
        model.addAttribute("fileServer", this.fileServerConfigure);
        return new ModelAndView("buyers/user/user-info");
    }

    /**
     * Cash model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     * @throws Exception the exception
     */
    @GetMapping("bank/{userId}")
    public ModelAndView userBank(@PathVariable Long userId, Model model) throws Exception {
        UserBank bank = this.userManager.findBankByUserId(userId);
        if (bank == null) {
            bank = new UserBank();
        }
        model.addAttribute("bank", bank);
        model.addAttribute("userId", userId);
        model.addAttribute("msg", "");
        return new ModelAndView("buyers/user/user-bank");
    }

    /**
     * Save bank string.
     *
     * @param userBank the user bank
     * @return the string
     * @throws Exception the exception
     */
    @PostMapping("bank/save")
    public String saveBank(UserBank userBank) throws Exception {
        if (userBank.getId() == null) {
            final int flag = this.userManager.insertBank(userBank);
            if (flag > 0) {
                return SUCCESS;
            }
        } else {
            final int flag = this.userManager.updateBank(userBank);
            if (flag > 0) {
                return SUCCESS;
            }
        }
        return ERROR;
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
        try {
            final List<TbUser> tbUser = this.tbUserManager.findTbUserNumByUserId(userId);
            if (null != tbUser || tbUser.size() > 0) {
                model.addAttribute("tbUser", this.tbUserManager.findTbUserNumByUserId(userId).get(0));
            } else {
                model.addAttribute("tbUser", new TbUser());
            }
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
        model.addAttribute("fileConfig", this.fileServerConfigure);
        return new ModelAndView("buyers/user/bind");
    }

    /**
     * Modify model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @RequestMapping("modifyLoginPwd/{userId}")
    public ModelAndView modify(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/modify-login-pwd");
    }

    /**
     * Modify model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @RequestMapping("modifyTelphone/{userId}")
    public ModelAndView modifyTelphone(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/modify-telphone");
    }

    /**
     * Modify model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("modifyQQ/{userId}")
    public ModelAndView modifyQQ(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/modify-qq");
    }

    /**
     * Modify model and view.
     *
     * @param userId the user id
     * @param qq     the qq
     * @return the model and view
     */
    @PostMapping("modifyQQ/{qq}/{userId}")
    public String modifyQQCode(@PathVariable Long userId, @PathVariable String qq) {
        final User uesr = this.userManager.findById(userId);
        final UserInfo userInfo = uesr.getUserInfo();
        userInfo.setQq(qq);
        return  this.updateUserInfo(userInfo);
    }

    /**
     * Modify tx string.
     *
     * @param userId the user id
     * @param tx     the tx
     * @return the string
     */
    @PostMapping("modifyTx/{tx}/{userId}")
    public String modifyTx(@PathVariable Long userId, @PathVariable String tx){
        final User uesr = this.userManager.findById(userId);
        final UserInfo userInfo = uesr.getUserInfo();
        userInfo.setTxUrl(tx);
        return this.updateUserInfo(userInfo);
    }
    private String updateUserInfo(UserInfo userInfo) {
        try {
            final int info = this.userManager.updateUserInfo(userInfo);
            if (info > 0) {
                return SUCCESS;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ERROR;
        }
        return FAILD;
    }

    /**
     * 修改用户地区，直接把地区名字用逗号组装一起保存
     *
     * @param userId the user id
     * @param city   the city
     * @return string string
     */
    @PostMapping("modifyCity/{city}/{userId}")
    public String modifyCityName(@PathVariable Long userId, @PathVariable String city) {
        final User uesr = this.userManager.findById(userId);
        final UserInfo userInfo = uesr.getUserInfo();
        userInfo.setCity(city);
        return this.updateUserInfo(userInfo);
    }

    /**
     * Modify model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @RequestMapping("modifyTradPwd/{userId}")
    public ModelAndView addTradPwd(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/modify-trad-pwd");
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
     * Upd telphone string.
     *
     * @param userId   the user id
     * @param telphone the telphone
     * @param valicode the valicode
     * @return the string
     */
    @PostMapping("updateTbUser/{userId}")
    public String updateTbUser(@PathVariable Long userId, String telphone, String valicode) {

        //需要看下。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
        final TbUser tbUser = new TbUser();

        try {
            this.tbUserManager.updateTbUserByUserId(tbUser);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return FAILD;
        }
        return SUCCESS;
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
        } else if (resultNum == -2) {
            return ERROR;
        }
        return FAILD;
    }

    /**
     * Update login string.
     *
     * @param newPwd the new pwd
     * @param userId the user id
     * @param type   the type 0:LOGIN_PWD, 1:TRAD_PWD
     * @return the string
     */
    @RequestMapping("tradPwd/{userId}/{type}")
    @ResponseBody
    public String addTradPwd(String newPwd, @PathVariable Long userId, @PathVariable Integer type) {
        final int resultNum = this.userManager.checkAndUpdatePwd(userId, "", newPwd, type);
        if (resultNum > 0) {
            return SUCCESS;
        } else if (resultNum == -2) {
            return ERROR;
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
    public String retrieve(String phoneNum, String valicode, String checkNum) {
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
     * @param passWord  the checknum
     * @return the string
     */
    @PostMapping("register")
    @ResponseBody
    public String register(String loginName, String qq, String phoneNum, String checknum, String passWord) {
        final String code = this.stringRedisTemplate.opsForValue().get(phoneNum);
        if (StringUtils.isNotBlank(code) && code.equals(checknum)) {
            try {
                this.userManager.register(loginName, qq, phoneNum, passWord);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return FAILD;
            }
            return SUCCESS;
        }
        return ERROR;
    }

    /**
     * Upd telphone string.
     *
     * @param userId   the user id
     * @param telphone the telphone
     * @param valicode the valicode
     * @return the string
     */
    @PostMapping("updateTelphone/{userId}")
    public String updTelphone(@PathVariable Long userId, String telphone, String valicode) {
        final String code = this.stringRedisTemplate.opsForValue().get(telphone);
        if (StringUtils.isNotBlank(code) && code.equals(valicode)) {
            final User user = this.userManager.findById(userId);
            final UserInfo userInfo = user.getUserInfo();
            userInfo.setTelphone(telphone);
            try {
                this.userManager.updateUserInfo(userInfo);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return FAILD;
            }
            return SUCCESS;
        }
        return ERROR;
    }
}
