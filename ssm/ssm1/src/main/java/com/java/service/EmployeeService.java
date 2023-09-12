package com.java.service;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getAllEmployeePage(Integer pageNum);

    //获取员工的分页信息
    
}
