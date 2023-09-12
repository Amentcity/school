package com.java.file;

public class User {
    public User() {
        System.out.println("1.bean对象创建，调用无参数构造");
    }

    //初始化的方法
    public void initMethod(){
        System.out.println("4.bean对象初始化，调用指定的初始化方法");
    }
    //销毁的方法
    public void destroyMethod(){
        System.out.println("7.bean对象销毁，调用指定的销毁方法");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.给bean休想设置属性值");
        this.name = name;
    }
}
