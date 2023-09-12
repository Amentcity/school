package com.java.mapper;

import com.java.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    //根据条件来查询员工信息
    List<Emp> getEmpByCondition(Emp emp);
    //使用choose查询员工信息
    List<Emp> getEmpByChoose(Emp emp);
    //批量添加员工信息
    int insertMoreEmp(@Param("emp") List<Emp> emp);
    //批量删除员工信息
    int deleteMoreEmp(@Param("empIds") int[] empIds);
}
