package com.java.ditest;

import java.util.List;

public class Department {
    private List<Employee> listEmp;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getListEmp() {
        return listEmp;
    }

    public void setListEmp(List<Employee> listEmp) {
        this.listEmp = listEmp;
    }

    public void info(){
        System.out.println("部门名称:"+name);
        for (Employee emp:listEmp) {
            System.out.println(emp.getName());
        }
    }

}
