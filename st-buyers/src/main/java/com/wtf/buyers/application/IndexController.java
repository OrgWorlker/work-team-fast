package com.wtf.buyers.application;

import com.wtf.core.domain.factory.MessageQueueFactory;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.interfaces.manager.IUserManager;
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
public class IndexController extends ControllerAdapter {

    @Resource
    private MessageQueueFactory messageQueueFactory;

    @Resource
    private IUserManager userManager;

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
     * Pages model and view.
     *
     * @param path the path
     * @param file the file
     * @return the model and view
     */
/*
     * Main string.
     * 页面跳转主入口
     * @param path the path
     * @return the string
     */
    @GetMapping("/{path}/{file}")
    public ModelAndView pages(@PathVariable String path,@PathVariable String file) {
        return new ModelAndView("buyers/" + path + "/" + file);
    }

    /**
     * User center model and view.
     *
     * @param model  the model
     * @param userId the user id
     * @return the model and view
     */
/*
     * Main string.
     * 页面跳转主入口
     * @param path the path
     * @return the string
     */
    @GetMapping("/user/user-center/{userId}")
    public ModelAndView userCenter(Model model,@PathVariable Long userId) {
        model.addAttribute("user", this.userManager.findById(userId));
        return new ModelAndView("buyers/user/user-center" );
    }

    /**
     * First into model and view.
     *
     * @param model  the model
     * @param userId the user id
     * @return the model and view
     */
/*
     * Main string.
     * 页面跳转主入口
     * @param path the path
     * @return the string
     */
    @GetMapping("/user/first-into/{userId}")
    public ModelAndView firstInto(Model model,@PathVariable Long userId) {
        model.addAttribute("user", this.userManager.findById(userId));
        return new ModelAndView("buyers/user/first-into" );
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
    public String sendShortMessage(@PathVariable String phoneNum){
        this.messageQueueFactory.sendShortMessage(phoneNum);
        return SUCCESS;
    }
}
