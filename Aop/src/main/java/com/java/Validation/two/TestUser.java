package com.java.Validation.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    @Test
    public void testValidationOne(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 bean = context.getBean(MyValidation1.class);
        User user=new User();
        user.setName("lucy");
        user.setAge(20);
        boolean b = bean.validatorByUserOne(user);
        System.out.println(b);
    }
    @Test
    public void testValidationTwo(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user=new User();
        user.setName("lucy");
        user.setAge(200);
        boolean b = validation2.validatorByUserTwo(user);
        System.out.println(b);
    }
}
