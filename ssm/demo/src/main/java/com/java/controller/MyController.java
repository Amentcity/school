package com.java.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {
    @RequestMapping(value = "/some.do",method= RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","欢迎使用");
        modelAndView.addObject("fun","执行的是doSome方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = "/other.do",method= RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","欢迎使用");
        modelAndView.addObject("fun","执行的是doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","欢迎使用"+request.getParameter("name "));
        modelAndView.addObject("fun","执行的是doFirst方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
