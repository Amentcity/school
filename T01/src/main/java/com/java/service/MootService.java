package com.java.service;

import com.java.entity.Entity;
import com.java.mapper.MootMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MootService {

    private MootMapper mootMapper;

    private SqlSession sqlSession;

    public MootService() throws IOException {
        //mybatis-config.xml目录位置
        String resource = "mybatis-config.xml";
        //解析mybatis-config.xml 得到数据库相关配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建得到一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        mootMapper = sqlSession.getMapper(MootMapper.class);
    }

    public List<Entity> selectAll(){
        return mootMapper.selectAll();
    }
    public  Entity getById(int id){
        return mootMapper.getById(id);
    }

    public int insertMoot(Entity entity){
        int result=mootMapper.insertMoot(entity);
        //需要手动提交事务
        sqlSession.commit();    //提交事务
        return result;
    }

    public int updateMoot(Entity entity){
        int result=mootMapper.updateMoot(entity);
        sqlSession.commit();
        return result;
    }

    public int deleteMoot(int id){
        int result = mootMapper.deleteMoot(id);
        sqlSession.commit();
        return result;
    }

    public List<Entity> getByIdMap(Map<String,String> map){
        return  mootMapper.getByIdMap(map);
    }

    public List<Entity> getByParam(String Teacher,int Chapter, int isFee){
        return  mootMapper.getByParam(Teacher,Chapter,isFee);
    }

    public List<Entity> getByPojo(Entity entity){
        return  mootMapper.getByPojo(entity);
    }
    public List<Entity> getByWhere(Entity entity){
        return  mootMapper.getByWhere(entity);
    }
}
