package com.java.controller;

import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller(value = "controller")
public class UserController {
    @Autowired(required = false)
    @Qualifier("userServiceImpl")
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    public UserService getUserService() {
        return userService;
    }
//    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.savaUser();
    }
}
