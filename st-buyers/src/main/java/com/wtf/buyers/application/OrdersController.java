package com.wtf.buyers.application;

import com.wtf.core.interfaces.manager.IUserTaskManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * The type Orders controller.
 */
@RestController
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

    /**
     * Order object.
     *
     * @param userId the user id
     * @return the object
     * @throws Exception the exception
     */
    @RequestMapping("auto")
    public Object order(Long userId) throws Exception {
        return this.userTaskManager.findOrderByNullBuyerAndStartTime(new Date());
    }

    /**
     * User task list object.
     *
     * @param userId the user id
     * @return the object
     * @throws Exception the exception
     */
    @RequestMapping("userTaskList")
    public Object userTaskList(Long userId) throws Exception {
        return  this.userTaskManager.findOrderByBuyerId(userId);
    }
}
