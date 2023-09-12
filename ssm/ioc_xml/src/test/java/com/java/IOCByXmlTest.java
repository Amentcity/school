package com.java;

import com.java.pojo.Clazz;
import com.java.pojo.Person;
import com.java.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {
    /*
    * 获取bean的三种方式：
    * 1.根据bean的id获取
    * 2.根据bean的类型获取
    * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
    * 若没有任何一个类型所匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
    * 若有多个类型所匹配的bean：此时抛出异常：NoUniqueBeanDefinitionException
    * 3.根据bean的id和类型获取
    * 结论:
    * 根据类型来获取bean时,在满足bean唯一的前提下
    * 其实只看：对象instanceof指定的类型返回结果
    * 只要返回的是true就可以认定为和类型匹配。能够获取到
    * 即通过bean的类型、bean所继承类的类型、bean所实现的接口的类型都可以获取都可以获取bean
    * */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("bean.xml");
        //获取bean
//        Student studentOne = (Student) ioc.getBean(Student.class);
//        System.out.println(studentOne);
//        Student studentOne = ioc.getBean("studentOne", Student.class);
//        System.out.println(studentOne);
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);
//        Student bean = ioc.getBean("studentThree", Student.class);
//        System.out.println(bean);
    }
    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("bean.xml");
//        Student bean = ioc.getBean("studentFive", Student.class);
//        System.out.println(bean);
//        Clazz clazzOne = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazzOne);
        Student bean = ioc.getBean("studentSix", Student.class);
        System.out.println(bean);
    }
}
