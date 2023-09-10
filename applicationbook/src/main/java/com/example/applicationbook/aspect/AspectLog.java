package com.example.applicationbook.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectLog {

    private Logger logger = Logger.getLogger(AspectLog.class.getName());
    @Pointcut("execution (* com.example.applicationbook.service.Bookservice.*(..))")
    public void bookService(){};

    @Before("execution(* com.example.applicationbook.service.Bookservice.*(..))")
    public void getLogAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: Call method BookService." + methodName);
    }

}

