package com.java.autoWriter.Service;

import com.java.autoWriter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //注入dao
    //第一种方式:属性注入
//    @Autowired //根据类型找到对用对象，完成注入
//    private UserDao userDao;
//
//    private UserDao userDao;
//
//    @Autowired
//    public void setUserDao(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //最后方式：两个注解，根据名称注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("service.......");
        userDao.add();
    }
}
