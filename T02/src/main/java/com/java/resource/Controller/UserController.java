package com.java.resource.Controller;

import com.java.resource.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //根据名称进行注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    //根据类型匹配
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("controller.....");
        userService.add();
    }
}
