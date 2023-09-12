import com.java.mapper.CacheMapper;
import com.java.pojo.Emp;
import com.java.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    // * mybatis的一级缓存(默认开启)
    // * mybatis的一级缓存是sqlSession级别的，即通过一个sqlSession查询的数据会被缓存
    // * 再次使用同一个sqlSession查询同一条数据，会从缓存中获取
    // * 使一级缓存失效的四种情况
    // * 1.不同的sqlSession对应不同的一级缓存
    // * 2.同一个sqlSession但是查询条件不同
    // * 3.同一个sqlSession两次查询期间执行了任何一次增删改操作
    // * 4.同一个sqlSession两次查询期间手动清空了缓存
    // *
    /*
    * mybatis的二级缓存：
    * mybatis的二级缓存是SqlSessionFactory级别的，即通过同一个sqlSessionFactory所获取的sqlSession对象
    * 查询的数据会背缓存，再次通过同一个sqlSessionFactory所获取的sqlSession查询相同的数据会从缓存中获取
    * Mybatis二级缓存开启的条件：
    * 1.在核心配置文件中，设置全局配置属性cacheEnable=“true”，默认为true，不需要设置
    * 2.在映射文件中设置标签<cache/>
    * 3二级缓存必须在sqlSession关闭或提交之后有效
    * 4.查询的数据所转换的实体类类型必须实现序列化的接口
    *
    *
    * 使二级缓存失效的情况
    * 两次查询之间实现了任意的增删改，会使一级和二级缓存同时失效
    * */

    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(1);
        System.out.println(empById);
        sqlSession.clearCache();
        Emp empById2 = mapper.getEmpById(1);
        System.out.println(empById2);
    }
    @Test
    public void testCache(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp empById = mapper.getEmpById(1);
            System.out.println(empById);
            sqlSession.close();
            SqlSession sqlSession1 = build.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp empById1 = mapper1.getEmpById(1);
            System.out.println(empById1);
            sqlSession1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
