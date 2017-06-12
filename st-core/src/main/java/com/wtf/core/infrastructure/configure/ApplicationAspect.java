package com.wtf.core.infrastructure.configure;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * The type Application aspect.
 */
@Component
@Aspect
@Slf4j
public class ApplicationAspect {

    /**
     * 拦截器具体实现
     *
     * @param pjp the pjp
     * @return JsonResult （被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("execution(public * com.wtf.*.application..*(..))")
    public Object Interceptor(ProceedingJoinPoint pjp){
         Object proceed;
        final long start = System.currentTimeMillis();
        try {
            proceed = pjp.proceed();
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            final HashMap<Object, Object> resultMap = new HashMap<>();
            resultMap.put("code", "500");
            resultMap.put("msg", "操作失败");
            resultMap.put("info", "");
            proceed = resultMap;
        } finally {
            final long time = System.currentTimeMillis() - start;
            if (time > 0) {
                log.debug("Request Time : {}(ms)", time);
            }
        }
        return proceed;
    }

}
