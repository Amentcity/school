package com.java.mapper;

import com.java.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    //通过用户名模糊查询用户信息
    List<User> getUserByLike(@Param("fuzzy") String fuzzy);
    int deleteMoreUser(@Param("ids") String ids);
    //动态设置表名，查询用户信息
    List<User> getUserList(@Param("tableName") String tableName);
    int insertUser(User user);

}
