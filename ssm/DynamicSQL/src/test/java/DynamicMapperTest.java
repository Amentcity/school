import com.java.mapper.DynamicSQLMapper;
import com.java.pojo.Emp;
import com.java.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(0,null,20,"男");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        empByCondition.forEach(System.out::println);
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(0,null,20,"男");
        List<Emp> empByChoose = mapper.getEmpByChoose(emp);
        empByChoose.forEach(System.out::println);
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(0,"小明",20,"男");
        Emp emp1=new Emp(0,"小张",20,"男");
        Emp emp2=new Emp(0,"小红",20,"女");
        List<Emp> list = Arrays.asList(emp, emp1, emp2);
        int i = mapper.insertMoreEmp(list);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int[] empIds=new int[]{8,9,10};
        int i = mapper.deleteMoreEmp(empIds);
        sqlSession.commit();
        System.out.println(i);
    }
}
