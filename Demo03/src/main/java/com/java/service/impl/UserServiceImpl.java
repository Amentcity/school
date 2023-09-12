package com.java.service.impl;

import com.java.anno.Bean;
import com.java.anno.Di;
import com.java.dao.UserDao;
import com.java.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service....");
        //调用Dao方法
        userDao.add();
    }
}
