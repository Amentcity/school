package com.java.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void testBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("book.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
    @Test
    public void testBook1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("book.xml");
        Book book = context.getBean("book1", Book.class);
        System.out.println(book);
    }
}
