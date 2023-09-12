package com.java;

import com.java.xml.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopByXMLTest {
    @Test
    public void testAopByXML(){
        ApplicationContext context=new ClassPathXmlApplicationContext("xml.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(1,3);
    }
}
