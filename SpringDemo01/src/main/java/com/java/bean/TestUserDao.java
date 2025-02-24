package com.java.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //根据类型获取接口对应bean
        UserDao bean = context.getBean(UserDao.class);
        System.out.println(bean);
        bean.run();
    }
}
