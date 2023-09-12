package com.java.mapper;

import com.java.entity.Entity;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.Map;

public interface MootMapper {

    List<Entity> selectAll();

    Entity getById(int id);

    int insertMoot(Entity entity);

    int updateMoot(Entity entity);

    int deleteMoot(int id);

    /**
     * 多条件查询Map集合传递参数
     * Map<String,String> map
     * map.put("");
     * key=CourseName
     * value=MySQL高级查询
     */
    List<Entity> getByIdMap(Map<String,String> map);

    List<Entity> getByParam(@Param("Teacher") String Teacher, @Param("Chapter") int Chapter, @Param("isFee") int isFee);

    List<Entity> getByPojo(Entity entity);
    List<Entity> getByWhere(Entity entity);
}
