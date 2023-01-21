package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //To intercept the return values
    @AfterReturning(
            value = "com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("{} returned with value {}", joinPoint, result);
    }

    //To intercept an exception
    @AfterThrowing(
            value = "com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            throwing = "exception")
    public void afterException(JoinPoint joinPoint, Object exception){
        logger.info("{} exception with {}", joinPoint, exception);
    }

    //To intercept the return values or exception
    @After("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint){
        logger.info("Using after AOP interception {}", joinPoint);
    }
}
