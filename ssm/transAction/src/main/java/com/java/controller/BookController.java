package com.java.controller;

import com.java.Service.BookService;
import com.java.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;
    public void buyBook(int userId,int bookId){
        bookService.buyBook(userId,bookId);
    }
    public void checkout(int userId,int[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
