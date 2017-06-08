package com.wtf.core.infrastructure.configure;


import com.wtf.core.domain.dto.UserLoginDto;
import com.wtf.core.domain.model.User;
import com.wtf.infsc.infrastructure.constant.Constant;
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
        final String redirectLogin = "/login";
        if (currentUser == null) {
            log.debug("用户未登录");
            log.debug(request.getRequestURI());
            response.sendRedirect(redirectLogin);
            return false;
        }
        final UserLoginDto userLoginDto = (UserLoginDto) currentUser;
        final User user = userLoginDto.getUser();
        if (user == null) {
            response.sendRedirect(redirectLogin);
            return false;
        }
        return true;
    }
}
