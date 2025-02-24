package com.java.resource;

import com.java.resource.Controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class TestUserController {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
