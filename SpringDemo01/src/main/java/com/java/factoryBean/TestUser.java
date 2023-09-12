package com.java.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("factoryBean.xml");
        User user= (User) context.getBean("user");
        System.out.println(user);
    }
}
