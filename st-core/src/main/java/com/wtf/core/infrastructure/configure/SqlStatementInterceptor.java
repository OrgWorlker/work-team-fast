package com.wtf.core.infrastructure.configure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * The type Sql statement interceptor.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@Slf4j
public class SqlStatementInterceptor implements Interceptor {

    @Getter
    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object returnValue;
        long start = System.currentTimeMillis();
        returnValue = invocation.proceed();
        if (log.isDebugEnabled()) {
            final MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            final String sqlId = mappedStatement.getId();
            final Logger logger = LoggerFactory.getLogger(sqlId);
            logger.debug("<==       Time: " + (System.currentTimeMillis() - start) + "(ms)");
        }
        return returnValue;
    }

    @Override
    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(Properties arg0) {
        this.properties = arg0;
    }

}
