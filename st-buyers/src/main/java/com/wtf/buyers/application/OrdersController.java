package com.wtf.buyers.application;

import com.wtf.core.interfaces.manager.IUserTaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * The type Orders controller.
 */
@Controller
@RequestMapping("order")
public class OrdersController {
    @Resource
    private IUserTaskManager userTaskManager;

    /**
     * Order page string.
     *
     * @return the string
     */
    @GetMapping
    public String orderPage() {
        return "auto-order";
    }

    @RequestMapping("auto")
    @ResponseBody
    public Object order(Long userId) throws Exception {
        return this.userTaskManager.findOrderByNullBuyerAndStartTime(new Date());
    }
}
