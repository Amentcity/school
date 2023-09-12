package com.java.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    @Test
    public void testEmp() {
        ApplicationContext context=new ClassPathXmlApplicationContext("ditest.xml");
        //员工对象
        Employee emp = context.getBean("emp1", Employee.class);
        emp.work();
    }
    @Test
    public void testEmp1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ditest.xml");
        Employee emp=context.getBean("emp2", Employee.class);
        emp.work();
    }
    @Test
    public void testEmp2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("di.xml");
        Employee emp = context.getBean("emp", Employee.class);
        emp.work();
    }
    @Test
    public void testDept(){
        ApplicationContext context=new ClassPathXmlApplicationContext("list.xml");
        Department dept = context.getBean("dept", Department.class);
        dept.info();
    }
}
