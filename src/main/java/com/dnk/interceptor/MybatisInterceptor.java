package com.dnk.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

//@Intercepts({@Signature(
//        type = ParameterHandler.class,
//        method = "setParameters",
//        args = {PreparedStatement.class})
//})
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class MybatisInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("target:{}", invocation.getTarget());
        logger.info("method:{}", invocation.getMethod());
        logger.info("args:{}", invocation.getArgs().length);
        for (Object arg : invocation.getArgs()) {
            logger.info("arg:{}", arg);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("-----------properties:");
        properties.entrySet().forEach(entry -> logger.info("key:{}-value:{}", entry.getKey(), entry.getValue()));
    }
}
