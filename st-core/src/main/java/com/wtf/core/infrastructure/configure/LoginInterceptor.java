package com.wtf.core.infrastructure.configure;


import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.core.infrastructure.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Login interceptor.
 * 登陆拦截器
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

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
        if (user == null) {
            response.sendRedirect(redirectLogin);
            return false;
        }
        return true;
    }

    private String getRequestDomain(HttpServletRequest request) {
//        final String requestURI = request.getRequestURI();
//        final String requestURL = request.getRequestURL().toString();
//        final String domainUrl = requestURL.replace(requestURI, "");
        return "/login";
    }
}
