package com.java.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {

    public void beforeMethod(){
        System.out.println("validateAspect-->前置通知");
    }

}
