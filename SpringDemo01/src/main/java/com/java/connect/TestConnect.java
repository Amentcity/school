package com.java.connect;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConnect {
    @Test
    public void Demo1(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/moot");
        dataSource.setUsername("root");
        dataSource.setPassword("zhiruo");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
    @Test
    public void Demo2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("connect.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean.getUrl()+bean.getUsername());
    }
}
