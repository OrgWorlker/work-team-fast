package com.wtf.core.infrastructure.stereotype;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by zc.lin on 2017/5/19.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Manager {
}
