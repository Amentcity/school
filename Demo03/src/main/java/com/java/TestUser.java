package com.java;

import com.java.bean.AnnotationApplicationContext;
import com.java.bean.ApplicationContext;
import com.java.service.UserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationApplicationContext("com.java");
        UserService userService= (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
