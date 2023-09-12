package com.java.file;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("life.xml");
        User bean = context.getBean("user", User.class);
        System.out.println("6.bean对象创建完成了，可以使用了");
        System.out.println(bean);
        context.close();//bean销毁
    }
}
