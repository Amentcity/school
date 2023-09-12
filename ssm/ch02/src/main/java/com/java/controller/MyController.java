package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    //处理方法返回ModelAndView，实现转发forWard
    //语法：serViewName("forward:视图文件完整路径")
    //forward特点：不和视图解析器一起使用，就当项目中没有视图解析器
    @RequestMapping("/doForward.do")
    public ModelAndView doSome(){
        ModelAndView view=new ModelAndView();
        view.addObject("msg","欢迎使用SpringMvc");
        view.addObject("fun","执行的是doSome方法");
        //显示转发
//        view.setViewName("forward:/WEB-INF/jsp/show.jsp");
        view.setViewName("forward:/hello.jsp");
        return view;
    }
    //处理器方法返回的是ModelAndView，实现重定向redirect
    //语法：setViewName("redirect:视图完整路径")
    //redirect特点：不和视图解析器一起使用，就当项目中没有视图解析器
    //框架对重定向的操作:
    //1.框架会把Model中的简单类型数据，转为String使用，作为hello.jsp的get请求参数使用
    //  目的是在doRedirect.do和hello.jsp两次请求之间传递数据
    //2.在目标hello.jsp页面可以使用参数集合对象${param}获取请求参数值
    //3.重定向不能访问/WEB-INF/资源
    //  ${param.name}
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name,Integer age){
        ModelAndView view=new ModelAndView();
        //数据方法request作用域
        view.addObject("name",name);
        view.addObject("age",age);
        //重定向
        view.setViewName("redirect:/hello.jsp");
//        view.setViewName("redirect:WEB-INF/jsp/show.jsp");
        return view;
    }
}
