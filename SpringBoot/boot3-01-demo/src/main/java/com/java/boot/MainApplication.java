package com.java.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//启动springboot项目的额主入口程序
@SpringBootApplication  //这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        //var:java10:局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);
        //1.获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2.挨个遍历 dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        //SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
        for (String name:names){
            System.out.println(name);
        }
    }
}
