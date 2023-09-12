package com.java.map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStu {
    @Test
    public void testStu(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ref.xml");
        Student student = context.getBean("student1", Student.class);
        student.run();
    }
}
