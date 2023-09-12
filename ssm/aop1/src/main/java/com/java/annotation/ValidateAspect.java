package com.java.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("com.java.annotation.LoggerAspect.pointCut())")
    public void beforeMethod(){
        System.out.println("validateAspect-->前置通知");
    }

}
