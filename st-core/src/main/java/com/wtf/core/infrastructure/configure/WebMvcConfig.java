package com.wtf.core.infrastructure.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * The type WebMvc Config.
 * WebMvc静态资源配置类
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login")
                .excludePathPatterns("/error")
                .excludePathPatterns("/register")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/retrieve")
                .excludePathPatterns("/retrieve-pwd")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/shortMessage/**")
                .excludePathPatterns("/**/favicon.ico");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }
}
