package com.java.tx;

import com.java.tx.config.SpringConfig;
import com.java.tx.connection.BookConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnno {
    @Test
    public void test(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        BookConnection bookConnection = context.getBean("bookConnection", BookConnection.class);
        int[] bookIds={1,2};
        bookConnection.checkout(bookIds,1);
    }
}
