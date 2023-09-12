package com.java.autoWriter.Controller;

import com.java.autoWriter.Service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //注入service
    //第一种方式:属性注入
//    @Autowired //根据类型找到对用对象，完成注入
//    private UserService userService;
//    public void add(){
//        System.out.println("controller.....");
//        userService.add();
//    }
    //第二种注入方式set方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    //第三种方式 构造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第四种方式 形参上注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    //第五种场景 只有一个有参数构造函数，无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        System.out.println("controller.....");
        userService.add();
    }
}
