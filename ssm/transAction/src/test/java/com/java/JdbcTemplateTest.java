package com.java;

import com.java.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//指定当前测试类在Spring的测试环境中执行，此时就可以直接通过注解的方式获取IOC容器中的bean
@ExtendWith(SpringExtension.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:jdbcTemplate.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testInsert(){
        String sql="insert into t_user values(null,?,?,?,?,?);";
       jdbcTemplate.update(sql,"root","123",123,"女","123@qq.com");
    }
    @Test
    public void testGetUserById(){
        String sql="select * from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }
    @Test
    public void getAllUser(){
        String sql="select * from t_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        query.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        String sql="select count(*) from t_user;";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }

}
