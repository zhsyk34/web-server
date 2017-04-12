package com.dnk.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(public * com.dnk.controller.*.*(..)) && !execution(public * com.dnk.controller.ExceptionController.handle(..))")
    public void controller() {
    }

    @Before("controller()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("------------------aop-------------------");
        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("controller()")
    public void doAfter() {
        logger.info("--------------------do after");
    }

    @AfterReturning(returning = "object", pointcut = "controller()")
    public void doAfterReturning(Object object) {
        logger.info("--------------------after return{}", object);
    }

    @AfterThrowing(pointcut = "controller()", throwing = "ex")
    public void doAfterThrowing(Exception ex) {
        logger.info("--------------------after throw{}", ex);
    }
}
