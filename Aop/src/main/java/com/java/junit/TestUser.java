package com.java.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:junit.xml")
@SpringJUnitConfig(locations = "classpath:junit.xml")
public class TestUser {
    //注入
    @Autowired
    private User user;
    //测试方法
    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }
}
