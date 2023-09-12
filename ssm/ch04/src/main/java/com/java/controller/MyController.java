package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age){
        System.out.println("===执行MyController中的doSome方法===");
        //处理doSome请求了。相当于service调用处理完成了
        ModelAndView view=new ModelAndView();
        view.addObject("name",name);
        view.addObject("age",age);
        view.setViewName("show");
        return view;
    }
}
