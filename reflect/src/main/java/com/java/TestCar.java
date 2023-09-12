package com.java;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    //1.获取Class对象的多种方式
    @Test
    public void test01() throws Exception {
       //1.类名.class
        Class<Car> class1=Car.class;
       //2.对象.getClass()
        Class class2=new Car().getClass();
       //3.Class.forName("全路径")
        Class class3 = Class.forName("com.java.Car");

        //实例化
        Car car = (Car) class3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }
    //2.获取构造方法
    @Test
    public void test02() throws Exception {
        Class class1 = Car.class;
        //获取所有构造
        //获取所有的public构造方法
        Constructor[] constructors = class1.getConstructors();
        //获取所有的构造方法 public private
//        Constructor[] constructors = class1.getDeclaredConstructors();
        for (Constructor c:constructors) {
            System.out.println("方法名称:"+c.getName()+"参数个数:"+c.getParameterCount());
        }
        //指定有参数构造创建对象
        //1.构造public
//        Constructor constructor = class1.getConstructor(String.class, int.class, String.class);
//        Car car = (Car) constructor.newInstance("夏利", 10, "红色");
//        System.out.println(car);
//        //2.构造private
        Constructor declaredConstructor = class1.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor.setAccessible(true);  //设置允许私有访问
        Car car1 = (Car) declaredConstructor.newInstance("捷达", 15, "白色");
        System.out.println(car1);
    }
    //3.获取属性
    @Test
    public void test03() throws Exception {
        Class class1 = Car.class;
        Car car = (Car) class1.getDeclaredConstructor().newInstance();
        //获取所有public属性
//        Field[] field = class1.getFields();
        //获取所有属性(包括私有属性)
        Field[] fields = class1.getDeclaredFields();
        for (Field f:fields) {
            if (f.getName().equals("name")){
                //设置语序访问
                f.setAccessible(true);
                f.set(car,"五菱宏光");
            }
            System.out.println(f.getName());
            System.out.println(car);
        }

    }
    //4.获取方法
    @Test
    public void test04() throws InvocationTargetException, IllegalAccessException {
        Car car=new Car("奔驰",10,"黑色");
        Class class1 = car.getClass();
        //1.public方法
        Method[] methods = class1.getMethods();
        for (Method method:methods) {
//            System.out.println(method.getName());
            //执行方法toString
            if (method.getName().equals("toString")){
                String invoke = (String) method.invoke(car);
//                System.out.println("toString方法执行了"+invoke );
            }
        }
        //2.private 方法
        Method[] methods1 = class1.getDeclaredMethods();
        for (Method method:methods1) {
            //执行方法run
            if (method.getName().equals("run")){
                method.setAccessible(true);
                method.invoke(car);
            }
        }
    }
}
