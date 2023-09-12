package com.java.Service.impl;

import com.java.Service.BookService;
import com.java.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;
    @Override
//    @Transactional
    public void checkout(int userId, int[] bookIds) {
        for (int id:bookIds) {
            bookService.buyBook(userId,id);
        }
    }
}
