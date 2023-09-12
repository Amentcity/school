package com.java.ditest;

import java.util.ArrayList;
import java.util.Arrays;

//员工类
public class Employee {

    //对象类型属性，员工属于某个部门
    private Department department;

    //员工名称
    private String name;
    //员工年龄
    private int age;
    //员工爱好
    private String[] hobby;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void work(){
        System.out.println(name+"emp work...."+age);
        department.info();
        System.out.println(Arrays.toString(hobby));
    }

}
