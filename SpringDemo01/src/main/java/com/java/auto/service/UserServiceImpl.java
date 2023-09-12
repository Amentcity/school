package com.java.auto.service;

import com.java.auto.dao.UserDao;
import com.java.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService里面的方法执行了...");
        userDao.addUserDao();
//        UserDao userDao=new UserDaoImpl();
//        userDao.addUserDao();
    }
}
