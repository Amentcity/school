package com.java;

import com.java.annotation.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopByAnnotationTest {
    @Test
    public void testAopByAnnotation(){
        ApplicationContext context=new ClassPathXmlApplicationContext("annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.div(10,1);
    }
}
