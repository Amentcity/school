package com.java.mapper;

import com.java.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("id") int id);
    //获取员工以及所对应的部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") int empId);
    //通过分步查询员工以及所对应的部门信息的第一步(多对一)
    Emp getEmpAndDeptByEmpStepOne(@Param("empId") int empId);
    //通过分步查询查询部门及部门中的员工信息的第二步(一对多)
    List<Emp> getDeptAndEmpByDeptStepTwo(@Param("deptId") int deptId);
}
