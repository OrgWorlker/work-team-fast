package com.wtf.infrastructure.configure;

import com.wtf.domain.dto.UserLoginDto;
import com.wtf.domain.model.User;
import com.wtf.infrastructure.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * The type Login interceptor.
 * 登陆拦截器
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    //运营商账号
    private static final Integer COME_FROM_ADMIN = 0;
    //卖家账号
    private static final Integer COME_FROM_SELLERS = 1;
    //手机端淘客账号
    private static final Integer COME_FROM_BUYERS = 2;
    //超级管理员账号
    private static final Integer COME_FROM_ROOT = 3;

    private static final String URL_SEP = "/";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object currentUser = request.getSession().getAttribute(Constant.CURRENT_USER);
        final String requestURI = request.getRequestURI();
        final String redirectLogin = this.getRequestDomain(request);
        if (currentUser == null) {
            log.debug("用户未登录");
            response.sendRedirect(redirectLogin);
            return false;
        }
        log.debug("已登录用户： {}", currentUser);
        final UserLoginDto userLoginDto = (UserLoginDto) currentUser;
        final User user = userLoginDto.getUser();
        boolean isLogin = false;
        if (user == null) {
            response.sendRedirect(redirectLogin);
        } else {
            if (user.getComeFrom().equals(COME_FROM_ADMIN) && requestURI.startsWith("/admin")) {
                isLogin = true;
            } else if (user.getComeFrom().equals(COME_FROM_SELLERS) && requestURI.startsWith("/sellers")) {
                isLogin = true;
            } else if (user.getComeFrom().equals(COME_FROM_BUYERS) && requestURI.startsWith("/buyers")) {
                isLogin = true;
            } else if (user.getComeFrom().equals(COME_FROM_ROOT)) {
                isLogin = true;
            } else {
                response.sendRedirect(redirectLogin);
            }
        }
        return isLogin;
    }

    private String getRequestDomain(HttpServletRequest request) {
        final String requestURI = request.getRequestURI();
        final String[] split = requestURI.split(URL_SEP);
        String filterName = "";
        if (split.length > 1) {
            filterName = split[1];
        }
        final String requestURL = request.getRequestURL().toString();
        final String domainUrl = requestURL.replace(requestURI, "");
        return domainUrl + URL_SEP + filterName +  "/login";
    }
}
