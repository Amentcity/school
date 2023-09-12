package com.java.auto;

import com.java.auto.connection.UserConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("auto.xml");
        UserConnection userConnection = context.getBean("userConnection", UserConnection.class);
        userConnection.addUser();
    }
}
