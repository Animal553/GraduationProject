package com.qianfeng.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {

    private final static Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Around("execution(public * com.qianfeng.springboot.controller..*.*(..))")
    public Object MyAspectImpl(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();
        Object r =null;

        try {
            logger.info(request.getRemoteAddr()+"发送请求...");
            logger.info(joinPoint.getSignature().getName()+"被调用...");
            r =joinPoint.proceed();
            logger.info(joinPoint.getSignature().getName()+"调用结束...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        return r;
    }
}
