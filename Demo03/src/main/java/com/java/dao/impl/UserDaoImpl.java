package com.java.dao.impl;

import com.java.anno.Bean;
import com.java.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao........");
    }
}
