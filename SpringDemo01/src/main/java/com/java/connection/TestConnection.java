package com.java.connection;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConnection {
    @Test
    public void demo(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://1.14.16.250:3306/moot");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
    @Test
    public void demo1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("connection.xml");
        DruidDataSource dataSource=context.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }
}
