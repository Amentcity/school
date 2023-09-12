package com.java.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/returnString.do")
    public String doReturnView(HttpServletRequest request,String name, int age){
        //可以手工添加数据到request到作用域
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        //show: 逻辑视图名称，项目中配置了逻辑视图解析器
        //框架对视图执行的是forward转发操作
        return "show";
    }
    //处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping("/returnString2.do")
    public String doReturnView2(HttpServletRequest request,String name, int age){
        //可以手工添加数据到request到作用域
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        //完整视图路径，项目中不能配置视图解析器
        //框架对视图执行的是forward转发操作
        return "/WEB-INF/templates/show.jsp";
    }
    //处理器方法返回void，相应ajax请求
    //手工实现ajax，json数据 代码有重复的    1.java对象转为json  2.通过HttpServletResponse输出json数据
    @RequestMapping("/returnAjax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, int age) throws IOException {
        //处理ajax，使用json做数据的格式
        //service调用完成了，使用Student表示处理结果
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        //把结果的对象转为json格式的数据
        String json=null;
        ObjectMapper mapper = new ObjectMapper();
        json=mapper.writeValueAsString(student);
        System.out.println("Student转换的json===="+json);
        //输出数据相应Ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
    //处理器方法返回一个student，通过框架转换为json，相应Ajax请求
    //@ResponseBody 作用：把处理器方法返回的对象转为json后，通过HttpServletResponses输出给浏览器
                  //位置：方法的定义上面。和其他注解没有顺序的关系。
    @RequestMapping("/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name,int age){
        //调用service，获取请求结果数据。student对象表示解结果数据
        Student student=new Student();
        student.setName("李四");
        student.setAge(20);
        return student;     //会被框架转换为json
    }
    //处理器方法返回List<Student>
    @RequestMapping("/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age){
        //调用service，获取请求结果数据。student对象表示解结果数据
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        student.setName("李四");
        student.setAge(20);
        list.add(student);
        student=new Student();
        student.setName("张三");
        student.setAge(20);
        list.add(student);
        return list;     //会被框架转换为json
    }
    //处理器方法返回的是String，String表示数据的，不是视图。
    //区分返回值String是数据，还是视图，看有没有@ResponseBody注解
    //如果有@ResponseBody注解，返回String就是数据，反之就是视图
    //默认使用text/plain;charset=ISO-8859-1 作为ContentType，导致中文乱码
    //解决方案：给@RequestMapping增加一个属性 produces，使用这个属性指定新的ContentType
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }
}
