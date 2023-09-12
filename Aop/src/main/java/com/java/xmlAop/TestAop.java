package com.java.xmlAop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beanaop.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(2,3);
    }
}
