package com.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
//    @org.junit.jupiter.api.Test
//    public void testUser(){
//        //1.加载spring配置文件，对象的创建
//        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//        //2.获取创建的对象
//        User bean = (User) context.getBean("user");
//        System.out.println("1."+bean);
//        //3.使用对象调用方法进行测试
//        System.out.print("2.");
//        bean.add();
//    }
//    //反射创建对象
//    @org.junit.jupiter.api.Test
//    public void test01() throws Exception {
//        //1.获取类Class对象
//        Class aClass = Class.forName("com.java.User");
//        //2.调用方法，创建对象
//        User user = (User)aClass.getDeclaredConstructor().newInstance();
//        System.out.println(user);
//    }


    private Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.jupiter.api.Test
    public void testHelloWorld(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        user.add();
        logger.info("执行成功");
    }

}
