package com.java.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/*
* 向域对象共享数据：
* 1.通过ModelAndView向请求域共享数据
*   使用ModelAndView时，可以使用其Model功能向请求域共享数据
*   使用view功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
* 2.使用Model向请求域共享数据
* 3.使用ModelMap向请求域共享数据
* 4.使用map向请求域共享数据
* 5.Model和ModelMap和Map的关系
* 在实际底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
*public class BindingAwareModelMap extends ExtendedModelMap{}
* public class ExtendedModelMap extends ModelMap implements Model{}
* public class ModelMap extends LinkedHashMap<String, Object>{}
* */
@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView test(){
        /*
         * ModelAndView包含Model和view的功能
         * Model:向请求域中共享数据
         * View:设置逻辑视图实现页面跳转
         * */
        ModelAndView view=new ModelAndView();
        //向请求域中共享数据
        view.addObject("testRequestScope","Hello ModelAndView");
        System.out.println(111);
        //设置逻辑视图
        view.setViewName("success");
        return view;
    }
    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope", "hello,Model");
        return "success";
    }
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }
    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName());
        map.put("testRequestScope", "hello,Map");
        return "success";
    }
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("tesetSessionScope","hello,Session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testMap(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello Application");
        return "success";
    }

}
