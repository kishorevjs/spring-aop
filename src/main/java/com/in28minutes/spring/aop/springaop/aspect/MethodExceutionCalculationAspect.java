package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExceutionCalculationAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.in28minutes.spring.aop.springaop..*.*(..))")
    public void afterReturning(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        proceedingJoinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {}", proceedingJoinPoint, timeTaken);
    }
}
