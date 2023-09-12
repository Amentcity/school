package com.java;

import com.java.controller.BookController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
* 声明式事务的配置步骤
* 1.在Spring的配置文件中配置事务管理器
* 2开启事务的注解驱动
* 在需要背事务管理的方法上，添加@Transactional注解，该方法就会背事务管理
* @Transactional注解标识的位置
* 1.标识在方法上
* 2.标识在类上，则类中所有的方法都会背事务管理
* */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByXml {
    @Autowired
    private BookController bookController;
    @Test
    public void testByBook(){
        bookController.buyBook(1,1);
    }
}
