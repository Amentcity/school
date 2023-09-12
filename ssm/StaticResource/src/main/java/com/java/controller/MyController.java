package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,int age){
        System.out.println("doSome name="+name+"   age="+age);
        ModelAndView view=new ModelAndView();
        view.addObject("name",name);
        view.addObject("age",age);
        view.setViewName("show");
        return view;
    }
}
