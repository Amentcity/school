package com.java.xmlTest;

import com.java.xmlTest.connection.BookConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:xml.xml")
public class TestAnno {
    @Autowired
    private BookConnection bookConnection;
    @Test
    public void testByBook(){
        bookConnection.buyBook(1,1);
    }
}
