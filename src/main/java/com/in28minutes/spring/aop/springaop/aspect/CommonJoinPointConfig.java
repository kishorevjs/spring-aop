package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("@annotation(com.in28minutes.spring.aop.springaop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
}
