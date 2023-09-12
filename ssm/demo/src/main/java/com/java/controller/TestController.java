package com.java.controller;

import com.java.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("receiveProperty.do")
    public ModelAndView doSome(String name,int age){
        ModelAndView view=new ModelAndView();
        view.addObject("name",name);
        view.addObject("age",age);
        view.setViewName("show");
        return view;
    }
    /*
    * 请求中参数名和处理器方法的形参名不一样
    * @RequestParam:解决请求中参数名和形参名不一样的问题
    *              属性:1.value  请求中参数的名称
    *                  2.required   是一个boolean，默认是true
    *                      true: 表示请求中必须包含此参数
    *              位置:在处理器方法的形参定义前面
    * */
    @RequestMapping("receiveParam.do")
    public ModelAndView receiveParam(@RequestParam(value = "userName",required = true)String name,@RequestParam("userAge") int age){
        ModelAndView view=new ModelAndView();
        view.addObject("name",name);
        view.addObject("age",age);
        view.setViewName("show");
        return view;
    }
    /*
    * 处理器方法 形参是Java对象，这个对象中属性名和请求中参数名一样的
    * 框架会创建形参的Java对象，给属性赋值。请求中的参数名是name，框架会调用setName()
    * */
    @RequestMapping("receiveObject.do")
    public ModelAndView receiveParam(Student myStudent){
        ModelAndView view=new ModelAndView();
        view.addObject("name",myStudent.getName());
        view.addObject("age",myStudent.getAge());
        view.addObject("student",myStudent);
        view.setViewName("show");
        return view;
    }
}
