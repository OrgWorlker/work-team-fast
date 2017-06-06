package com.wtf.event.infrastructure.configure;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * The type Mybatis configure.
 * MyBatis配置类
 */
@Configuration
public class MybatisConfigure {

    /**
     * Page helper page helper.
     * 分页插件
     *
     * @return the page helper
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }


    /**
     * Sql statement interceptor sql statement interceptor.
     *
     * @return the sql statement interceptor
     */
    @Bean
    public SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }
}
