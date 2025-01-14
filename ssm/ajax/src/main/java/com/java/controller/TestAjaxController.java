package com.java.controller;

import com.java.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/*
* 1.@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
* 2.使用@RequestBody注解将json格式的请求参数转换为java对象
* a>导入jackson的以来
* b>在springmvc的配置文件中设置<mvc:annotation-driven/>
* c>在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换的Java类型的形参，使用@RequestBody注解标识即可
* 3.@@ResponseBody:将所标识的控制器方法的返回值作为响应报文的响应题响应到浏览器
* 4.使用@ResponseBody注解响应浏览器json格式的数据
* a>导入jackson以来
* b>在springmvc的配置文件中设置<mvc:annotation-driven/>
* c>将需要转换成json字符串的Java对象直接作为控制器返回值，使用@ResponseBody注解标识控制器方法
* 就可以将java对象直接转换成json字符串，并响应到浏览器
*
* 常用的Java对象转换为json的结果
* 实体类-->json对象
* map-->json对象
* list-->json数组
* */
@Controller
//@RestController 相当于@Controller+@ResponseBody
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody"+requestBody);
        response.getWriter().println("hello,axios");
    }
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().println("hello,RequestBody");
    }
    public void testRequestBody(@RequestBody User user,HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().println("hello,RequestBody");
    }
    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "cuccess";
    }
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
//    public User testResponseBodyJson(){
//        return new User(1001,"admin","123456",20,"男");
//    }
//    public Map<String,Object> testResponseBodyJson(){
//        User user = new User(1001, "admin", "123456", 20, "男");
//        User user1 = new User(1002, "admin", "123456", 20, "男");
//        User user2 = new User(1003, "admin", "123456", 20, "男");
//        Map<String,Object> map=new HashMap<>();
//        map.put("1001",user);
//        map.put("1002",user1);
//        map.put("1003",user2);
//        return map;
//    }
    public List<User> testResponseBodyJson(){
        User user = new User(1001, "admin", "123456", 20, "男");
        User user1 = new User(1002, "admin", "123456", 20, "男");
        User user2 = new User(1003, "admin", "123456", 20, "男");
//        List<User> list=new ArrayList<>();
//        list.add(user);
//        list.add(user1);
//        list.add(user2);
        return Arrays.asList(user, user1, user2);
    }
}
