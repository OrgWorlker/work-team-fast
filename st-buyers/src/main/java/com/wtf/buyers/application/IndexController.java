package com.wtf.buyers.application;

import com.wtf.core.domain.event.ShortMsgEvent;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.interfaces.manager.ITbUserManager;
import com.wtf.core.interfaces.manager.IUserManager;
import com.wtf.infsc.infrastructure.configure.FileServerConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * The type Index controller.
 */
@Controller
@Slf4j
public class IndexController extends ControllerAdapter {

    @Resource
    private ShortMsgEvent shortMsgEvent;

    @Resource
    private IUserManager userManager;


    @Resource
    private ITbUserManager tbUserManager;
    @Resource
    private FileServerConfigure fileServerConfigure;

    /**
     * Main string.
     * 页面跳转主入口
     *
     * @param path the path
     * @return the string
     */
    @GetMapping("/{path}")
    public ModelAndView page(@PathVariable String path) {
        return new ModelAndView("buyers/" + path);
    }

    /**
     * User center model and view.
     *
     * @param model  the model
     * @param userId the user id
     * @return the model and view
     */
    @GetMapping("/user/user-center/{userId}")
    public ModelAndView userCenter(Model model, @PathVariable Long userId) {
        model.addAttribute("user", this.userManager.findById(userId));
        model.addAttribute("userId", userId);
        model.addAttribute("fileServer", this.fileServerConfigure);
        return new ModelAndView("buyers/user/user-center");
    }


    /**
     * First into model and view.
     *
     * @param model  the model
     * @param userId the user id
     * @return the model and view
     */
    @GetMapping("/user/first-into/{userId}")
    public ModelAndView firstInto(Model model, @PathVariable Long userId) {
        model.addAttribute("user", this.userManager.findById(userId));
        model.addAttribute("userId", userId);
        return new ModelAndView("buyers/user/first-into");
    }

    /**
     * Header string.
     *
     * @return the string
     */
    @GetMapping("public/header")
    public ModelAndView header() {
        return new ModelAndView("public/header");
    }

    /**
     * Send short message string.
     *
     * @param phoneNum the phone num
     * @return the string
     */
    @GetMapping("shortMessage/{phoneNum}")
    @ResponseBody
    public String sendShortMessage(@PathVariable String phoneNum) {
        this.shortMsgEvent.sendShortMessage(phoneNum);
        return SUCCESS;
    }
}
