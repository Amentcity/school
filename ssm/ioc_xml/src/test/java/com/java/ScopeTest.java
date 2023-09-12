package com.java;

import com.java.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope(){
        ApplicationContext context=new ClassPathXmlApplicationContext("scope.xml");
        Student bean = context.getBean(Student.class);
        Student bean1 = context.getBean(Student.class);
        System.out.println(bean.equals(bean1));
    }
}
