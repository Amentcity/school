package com.java.tx.connection;

import com.java.tx.service.BookService;
import com.java.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookConnection {
//    @Autowired
    private BookService bookService;

    //买书的方法，图书id和用户id
    public void buyBook(int bookId,int userId)  {
        //调用service方法
        bookService.buyBook(bookId,userId);
    }
    @Autowired
    private CheckoutService checkoutService;

    public void  checkout(int[] booksId,int userId){
        checkoutService.checkout(booksId,userId);
    }
}
