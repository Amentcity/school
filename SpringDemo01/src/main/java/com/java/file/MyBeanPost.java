package com.java.file;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyBeanPost implements BeanPostProcessor {
    //初始化之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3.bean后置处理器，初始化之前执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }
    //初始化之后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5.bean后置处理器，初始化之后执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }
}