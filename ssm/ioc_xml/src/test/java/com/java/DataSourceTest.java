package com.java;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("dataSource.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean.getConnection());
    }
}
