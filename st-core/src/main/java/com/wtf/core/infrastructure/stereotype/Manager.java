package com.wtf.core.infrastructure.stereotype;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * The interface Manager.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Manager {
}
