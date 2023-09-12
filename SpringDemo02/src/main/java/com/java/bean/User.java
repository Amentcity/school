package com.java.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//这四个注解都能创建对象
/*
* @Controller 用在web层
* @Service 用在service层
* @Repository 用在dao层
* @Component 作为普通bean的定义
* */
@Component(value = "user")      //类似于<bean id="user" class="包类路径">
@Repository
@Service
@Controller
// value可以不写 value值默认为类的首字母小写
public class User {
}
