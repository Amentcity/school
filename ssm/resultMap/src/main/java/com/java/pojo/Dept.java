package com.java.pojo;

import java.util.List;

public class Dept {
    private int deptId;
    private String deptName;
    private List<Emp> emp;

    public Dept() {
    }

    public Dept(int deptId, String deptName, List<Emp> emp) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.emp = emp;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emp=" + emp +
                '}';
    }
}
