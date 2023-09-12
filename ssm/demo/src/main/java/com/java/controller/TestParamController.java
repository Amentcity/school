package com.java.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
* 获取请求参数的方式:
* 1.通过ServletAPI获取
*   只需要在控制器方法的形参位置设置HttpServletRequest类型的参数
*   就可以在控制器方法中使用request对象获取请求参数
* 2.通过控制器方法的形参获取
*   只需要在控制器方法的形参位置，设置一个形参，形参的名字要和请求参数的名字一致即可
* 3.@RequestParam注解的三个属性
*   value:设置和形参绑定的请求参数的名字
*   required:设置是否必须传递value所对应的请求参数，默认值为true，标识value所对应的请求参数必须传输，否则报错:
*   400 - Required String Parameter "xxx" is not present
*   若设置为false，则表示value所对应的请求参数不是必须传输，若未传输，则形参值为null
*   defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
* 4.@RequestHeader：将请求头信息和控制器方法的形参绑定
* 5.@CookieValue:将cookie数据和控制器放法的形参绑定
* 6.通过控制器方法的实体类类型的形参获取参数，需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中属性的属性名和请求参数的名字一致
*   可以通过实体类类型的形参获取请求参数
* 7.解决获取请求参数的乱码问题
*   在web.xml中配置Spring的编码过滤器
* */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String GetParamByServletApi(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }
    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username") String username, String password,@RequestHeader("referer") String referer,@CookieValue("JSESSIONID") String cookie){
        System.out.println(referer);
        System.out.println(cookie);
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
