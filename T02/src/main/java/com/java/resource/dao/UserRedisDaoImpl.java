package com.java.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("UserRedisDaoImpl......");
    }
}
