package com.java.xmlTest.connection;

import com.java.xmlTest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookConnection {
    @Autowired
    private BookService bookService;

    //买书的方法，图书id和用户id
    public void buyBook(int bookId,int userId)  {
        //调用service方法
        bookService.buyBook(bookId,userId);
    }

}
