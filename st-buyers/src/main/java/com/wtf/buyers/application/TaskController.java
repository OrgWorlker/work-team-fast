package com.wtf.buyers.application;

import com.wtf.core.domain.model.UserOrder;
import com.wtf.core.interfaces.manager.ITbUserManager;
import com.wtf.core.interfaces.manager.IUserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class TaskController {
    @Resource
    private ITbUserManager tbUserManager;
    @Resource
    private IUserManager userManager;

    /**
     * Task welfare model and view.
     *
     * @param userId the user id
     * @param model  the model
     * @return the model and view
     */
    @GetMapping("/task/welfare/{userId}")
    public ModelAndView taskWelfare(@PathVariable Long userId, Model model, HttpSession session) {
        model.addAttribute("userId", userId);
        try {
            final Long time = (Long)session.getServletContext().getAttribute("time");
            System.out.println(time);
            model.addAttribute("tbUsers", this.tbUserManager.findTbUserNumByUserId(userId));
            final UserOrder userOrder = this.userManager.findUserOrderByUserId(userId);
            model.addAttribute("orderCount", userOrder.getOrderCount());
            if (userOrder.getOrderCount() == 0) {
                model.addAttribute("orderPvg", 0);
            } else {
                model.addAttribute("orderPvg", userOrder.getSuccessCount() * 100 / userOrder.getOrderCount());
            }
            model.addAttribute("time", (System.currentTimeMillis() - time)/6000);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new ModelAndView("buyers/task/welfare");
    }
}
