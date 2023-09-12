package com.java.controller;

import com.java.exception.AgeException;
import com.java.exception.MyUserException;
import com.java.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        //处理doSome请求了。相当于service调用处理完成了
        ModelAndView view=new ModelAndView();
        //根据请求参数抛出异常
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (age==null||age>80){
            throw new AgeException("年龄比较大！！！");
        }
        view.addObject("name",name);
        view.addObject("age",age);
        view.setViewName("show");
        return view;
    }
}
