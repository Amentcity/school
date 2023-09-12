package com.java.Validation.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

//检验测试
public class TestPerson {
    public static void main(String[] args) {
        //创建Person对象
        Person person=new Person();
        person.setName("lucy");
        person.setAge(250);
        //创建person对应dataBinder
        DataBinder dataBinder=new DataBinder(person);
        //设置校验器
        dataBinder.setValidator(new PersonValidator());
        //调用方法执行校验
        dataBinder.validate();
        //输出校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult);
    }
}
