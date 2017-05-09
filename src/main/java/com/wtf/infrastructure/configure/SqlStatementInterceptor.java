package com.wtf.infrastructure.configure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

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
    public Object intercept(Invocation arg0) throws Throwable {
        Object returnValue;
        long start = System.currentTimeMillis();
        returnValue = arg0.proceed();
        if (log.isDebugEnabled()) {
            final MappedStatement mappedStatement = (MappedStatement) arg0.getArgs()[0];
            final String sqlId = mappedStatement.getId();
            log.debug(sqlId + ": " + (System.currentTimeMillis() - start) + "ms");
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
