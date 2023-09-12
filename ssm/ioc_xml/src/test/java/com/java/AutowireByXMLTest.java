package com.java;

import com.java.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {
    /*
    * 自动装配
    * 根据指定策略，在ioc容器中匹配某个bean，自动为bean中的类类型属性或接口类型的属性赋值
    * 可以通过bean标签中的autowire属性设置自动装配的策略
    * 自动装配的策略：
    * 1.no,default:表示不装配，即bean中的某个属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
    * 2.byType：根据要赋值的属性类型，在IOC容器中匹配某个bean，为属性赋值
    * 注意：
    * a.若通过类型没有找到任何一个类型匹配的bean，此时不装配
    * b.若通过类型找到了多个匹配的bean，此时会抛出异常NoUniqueBeanDefinitionException
    * 总结:当使用byType实现自动装配时，IOC容器中有且只有一个匹配的bean能够为属性赋值
    * 3.byName:将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
    * 总结：当类型匹配的bean有多个时，此时可以使用byName实现自动装配
    * */
    @Test
    public void testAutowire(){
        ApplicationContext context=new ClassPathXmlApplicationContext("autoWrite.xml");
        UserController bean = context.getBean(UserController.class);
        bean.saveUser();
    }
}
