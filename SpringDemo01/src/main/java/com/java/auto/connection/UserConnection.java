package com.java.auto.connection;

import com.java.auto.service.UserService;
import com.java.auto.service.UserServiceImpl;

public class UserConnection {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        userService.addUserService();
        System.out.println("Connection方法执行了...");
//        UserService userService=new UserServiceImpl();
//        userService.addUserService();
    }
}
