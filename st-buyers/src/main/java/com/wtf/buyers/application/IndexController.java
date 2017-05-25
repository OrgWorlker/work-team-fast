package com.wtf.buyers.application;

import com.wtf.core.domain.factory.MessageQueueFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * The type Index controller.
 */
@Controller
public class IndexController {

    @Resource
    private MessageQueueFactory messageQueueFactory;
     /**
     * Main string.
     * 页面跳转主入口
     * @param path the path
     * @return the string
     */
    @GetMapping("/{path}")
    public ModelAndView page(@PathVariable String path) {
        this.messageQueueFactory.send();
        return new ModelAndView("buyers/" + path);
    }

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
     * Header string.
     *
     * @return the string
     */
    @GetMapping("public/header")
    public ModelAndView header() {
        return new ModelAndView("public/header");
    }
}
