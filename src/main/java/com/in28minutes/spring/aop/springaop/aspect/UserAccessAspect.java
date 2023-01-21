package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect //PointCut + Advice
@Configuration
public class UserAccessAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution (* PACKAGE.*.*(..))

    @Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()") //PointCut : "execution(* com.in28minutes.spring.aop.springaop..*.*(..))"
    public void before(JoinPoint joinPoint){ //Join Point - A point which belongs to the execution of a method/handling exception
        //Advice - logic to perform
        logger.info("Check for user access");
        logger.info("Intercepting method call - {}", joinPoint);
    }
}
