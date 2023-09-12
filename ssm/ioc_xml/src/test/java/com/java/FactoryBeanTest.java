package com.java;

import com.java.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void testFactoryBean(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
