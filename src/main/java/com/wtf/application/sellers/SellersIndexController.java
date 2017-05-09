package com.wtf.application.sellers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zc.lin on 2017/5/5.
 */
@Controller
@RequestMapping("sellers")
public class SellersIndexController {

    @GetMapping({"/", "index"})
    public String index() {
        return "sellers/index";
    }

    @GetMapping("login")
    public String login() {
        return "sellers/login";
    }

    @GetMapping("public/header")
    public String header() {
        return "public/header";
    }
}
