package com.java.mapper;

import com.java.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    //通过分步查询员工以及所对应的部门信息的第二步(多对一)
    Dept getEmpAndDeptByStepTwo(@Param("deptId") int deptId);
    Dept getEmpAndDeptById(@Param("deptId") int deptId);
    //通过分步查询查询部门及部门中的员工信息的第一步(一对多)
    Dept getDeptAndEmpByStepOne(@Param("deptId") int deptId);
}
