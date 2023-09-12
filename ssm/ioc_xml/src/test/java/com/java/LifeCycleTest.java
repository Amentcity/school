package com.java;

import com.java.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /*
    *1.实例化
    * 2.依赖注入
    * 3后置处理器的postProcessBeforeInitialization方法
    * 4.初始化，需要通过bean的init-method属性指定初始化的方法
    * 5.后置处理器的postProcessAfterInitialization方法
    * 6.IOC容器关闭时销毁，需要通过bean的destroy-method属性指定初始化的方法
    *
    * bean的后置处理器会在bean的生命周期初始化前后添加额外的操作
    * 需要实现BeanPostProcessor接口且配置到IOC容易中
    * 需要注意的是，bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有的bean都会执行
    *
    * 注意：
    * 若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
    * 若bean的作用域为多例时，生命周期的前三个步骤会在获取bean的时候执行
    * */
    @Test
    public void test(){
        //ConfigurableApplicationContext是ApplicationContext的子接口，其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("lifecycle.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
        context.close();
    }
}
