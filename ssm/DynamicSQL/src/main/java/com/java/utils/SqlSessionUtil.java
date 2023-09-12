package com.java.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession=null;
        //获取核心配置文件的输入流
        try {
            InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder factoryBuilder=new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory
            SqlSessionFactory build = factoryBuilder.build(input);
            //获取SqlSession对象
            sqlSession = build.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
