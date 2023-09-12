package com.java.test;

import com.java.mapper.EmpMapper;
import com.java.pojo.Emp;
import com.java.pojo.EmpExample;
import com.java.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MBGTest {
    //根据主键id查询
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
    //查询所有数据
    @Test
    public void selectAllTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emp = mapper.selectByExample(null);
        emp.forEach(System.out::println);
    }
    //根据条件查询数据
    @Test
    public void selectById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample example=new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三");
        example.or().andAgeGreaterThan(20);
        List<Emp> emp = mapper.selectByExample(example);
        emp.forEach(System.out::println);
    }
    //测试普通修改功能
    @Test
    public void updateSimple(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(1,"小黑",null,"女",1);
        int i = mapper.updateByPrimaryKey(emp);
        sqlSession.commit();
        System.out.println(1);
    }
    //测试选择性修改
    @Test
    public void updateSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(1,"小黑",null,"女",1);
        mapper.updateByPrimaryKeySelective(emp);
    }
}
