package com.wtf.admin.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zc.lin on 2017/5/5.
 */
@Controller
public class IndexController {

    @GetMapping({"/", "index"})
    public String index() {
        return "admin/index";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("public/header")
    public String header() {
        return "admin/header";
    }
}
