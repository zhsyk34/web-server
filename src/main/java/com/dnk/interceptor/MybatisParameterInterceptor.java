package com.dnk.interceptor;

import com.dnk.repository.LockRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class MybatisParameterInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MybatisParameterInterceptor.class);

    public static void main(String[] args) throws NoSuchMethodException {
        ParameterNameDiscoverer discoverer = new
//                DefaultParameterNameDiscoverer()
                LocalVariableTableParameterNameDiscoverer();
        Method[] methods = LockRepository.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            String[] parameterNames = discoverer.getParameterNames(method);
            if (parameterNames != null) {
                for (String name : parameterNames) {
                    System.out.println(name);
                }
            }
        }
    }

    @Pointcut("execution(public * com.dnk.repository.*.*(..))")
//    @Pointcut("this(com.dnk.repository.AutoResolver)")
//    @Pointcut("execution(public Object org.apache.ibatis.reflection.ParamNameResolver.getNamedParams(Object[]))")
//    @Pointcut("execution(* org.apache.ibatis.binding.*.convertArgsToSqlCommandParam(..))")
//    @Pointcut("execution(* org.apache.ibatis.binding.MapperProxy.invoke(..))")
//    @Pointcut("execution(* org.apache.ibatis.binding.MapperMethod.*(..))")
    public void repository() {
    }

    //    @Around("repository()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.err.println("---------------");
        Map<String, Object> map = new HashMap<>();
        Object[] args = point.getArgs();

        Object target = point.getTarget();
        logger.info("controller:{}", target);
        logger.info("this:{}", point.getThis());
        logger.info("kind:{}", point.getKind());
        logger.info("signature:{}", point.getSignature().getName());
        logger.info("type:{}", point.getSourceLocation().getWithinType());
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        logger.info("method:{}", method);
        logger.info("args:{}", args.length);
        for (int i = 0; i < args.length; i++) {
            logger.info("arg{}:{}", i, args[i]);
//            map.put()
        }

        System.err.println(point.getStaticPart().getSignature());
//        System.err.println(point.getSourceLocation().getClass());

//        System.out.println(parameterNames.length);
//        for (String parameterName : parameterNames) {
//            logger.info("param name:{}", parameterName);
//        }

//        return point.proceed(new Object[]{map});
        return point.proceed(args);
    }

}
