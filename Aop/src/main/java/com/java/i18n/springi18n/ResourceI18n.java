package com.java.i18n.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
        Object[] objects=new Object[]{"baidu",new Date().toString()};
        String message = context.getMessage("www.baidu.com", objects, Locale.CHINA);
        System.out.println(message);
    }
}
