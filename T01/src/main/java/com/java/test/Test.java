package com.java.test;

import com.java.mapper.UserMapper;
import com.java.service.MootService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.entity.Entity;

public class Test {

    public static void main(String[] args) throws IOException {
//        //mybatis-config.xml目录位置
//        String resource = "mybatis-config.xml";
//        //解析mybatis-config.xml 得到数据库相关配置信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建得到一个SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //获取到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
////        List<Entity> selectAll = sqlSession.selectList("selectAll", Entity.class);
////        System.out.println(selectAll);
//        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//        List<Entity> entities = userMapper.selectAll();
//        System.out.println(entities);
//        sqlSession.close();
        MootService mootService = new MootService();
//        List<Entity> entities = mootService.selectAll();
//        Entity byId = mootService.getById(10);
//        System.out.println(byId);
//        Entity entity=new Entity();
//        entity.setCourseName("Html5响应式设计");
//        entity.setTeacher("李四");
//        entity.setChapter(11);
//        entity.setPeriod(12);
//        entity.setIsFee(0);
//        entity.setIntro("响应设备尺寸，方便用户使用");
//        entity.setCourseID(10);
////        int i = mootService.insertMoot(entity);
////        System.out.println(i);
//        int i = mootService.updateMoot(entity);
//        System.out.println(i);
//        int i = mootService.deleteMoot(6);
//        System.out.println(i);
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("Teacher","程序员");
//        stringStringHashMap.put("Chapter","11");
//        stringStringHashMap.put("isFee","1");
//        List<Entity> byIdMap = mootService.getByIdMap(stringStringHashMap);
//        System.out.println(byIdMap);
//        List<Entity> entity = mootService.getByParam("程序员", 11, 1);
//        System.out.println(entity);
        Entity entity = new Entity();
        entity.setTeacher("");
        entity.setChapter(15);
        entity.setIsFee(0);
        List<Entity> byPojo = mootService.getByWhere(entity);
        System.out.println(byPojo);
    }

}
