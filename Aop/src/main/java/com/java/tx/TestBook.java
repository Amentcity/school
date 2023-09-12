package com.java.tx;

import com.java.tx.connection.BookConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBook {
    @Autowired
    private BookConnection bookConnection;

    @Test
    public void testBuyBook() {
//        bookConnection.buyBook(1, 1);
        int[] bookIds={1,2};
        bookConnection.checkout(bookIds,1);
    }
}
