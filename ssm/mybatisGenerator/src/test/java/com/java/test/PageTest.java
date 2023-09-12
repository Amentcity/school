package com.java.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.EmpMapper;
import com.java.pojo.Emp;
import com.java.pojo.EmpExample;
import com.java.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> objects = PageHelper.startPage(2, 4);
        List<Emp> emp = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo=new PageInfo<>(emp,5);
        emp.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
