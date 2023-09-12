package com.java.resource.perfix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:bean2.xml");
//        Resource resource = context.getResource("bean.txt");
//        System.out.println(resource.getDescription());
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
