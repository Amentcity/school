package com.java.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext Context=new ClassPathXmlApplicationContext("bean.xml");
        //1.根据id获取bean
        User user = (User) Context.getBean("user");
        System.out.println("根据id获取bean"+user);
        //2.根据类型获取bean
        User bean = Context.getBean(User.class);
        System.out.println("根据类型获取bean"+bean);
        //3.根据id和类型获取bean
        User user1 = Context.getBean("user", User.class);
        System.out.println("根据id和类型获取bean"+user1);
    }
}
