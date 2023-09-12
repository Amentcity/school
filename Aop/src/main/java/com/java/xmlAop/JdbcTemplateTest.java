package com.java.xmlAop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询返回对象
    @Test
    public void testSelectObject(){
        //写法一
//        String sql="select * from t_emp where id=?";
//        Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Emp emp = new Emp();
//            emp.setId(rs.getInt("id"));
//            emp.setName(rs.getString("name"));
//            emp.setAge(rs.getInt("age"));
//            emp.setSex(rs.getString("sex"));
//            return emp;
//        }, 2);
//        System.out.println(empResult);
        String sql="select * from t_emp where id=?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 2);
        System.out.println(emp);
    }
    // 查询返回list集合
    @Test
    public void testSelectList(){
        String sql="select * from t_emp";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(query);
    }
    //查询返回单个值
    @Test
    public void testSelectValue(){
        String sql="select count(*) from t_emp";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
    @Test
    public void testUpdate(){
//        //添加操
//        String sql="insert into t_emp values(null,?,?,?)";
//        //第二步调用jdbcTemplate的方法，传入相关参数
//        Object[] params={"东方不败", 20, "未知"};
//        int update = jdbcTemplate.update(sql, params);
//        System.out.println(update);
//        //修改操作
//        String sql="update t_emp set name=? where id=?";
//        int update = jdbcTemplate.update(sql, "林平之",1);
//        System.out.println(update );
        //删除操作
        String sql="delete from t_emp where id=?";
        int update = jdbcTemplate.update(sql, 1);
        System.out.println(update);
    }
}
