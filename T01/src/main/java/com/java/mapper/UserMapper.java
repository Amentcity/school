package com.java.mapper;

import com.java.entity.Entity;

import java.util.List;

public interface UserMapper {

    //selectAll与mapper里面的id对应
    List<Entity> selectAll();

}
