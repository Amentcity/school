package com.java.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.java.tx")
@EnableTransactionManagement    //开启事务管理
public class SpringConfig {
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("zhiruo");
        return dataSource;
    }
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getjdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public DataSourceTransactionManager getdataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;
    }
}
