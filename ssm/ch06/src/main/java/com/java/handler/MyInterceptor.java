package com.java.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

//拦截器类：拦截用户的请求。
public class MyInterceptor implements HandlerInterceptor {
    //验证登录的用户信息，正确return true，其他return false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1拦截器的MyInterceptor的preHandle()方法");
        //从session中获取name的值
        String loginName="";
        Object name = request.getSession().getAttribute("name");
        if(name!=null){
            loginName= (String) name;
        }
        //判断登录的账号，是否符合要求
        if (!"zs".equals(loginName)){
            //不能访问系统
            //给用户提示
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        //zs登录
        return true;
    }

}
