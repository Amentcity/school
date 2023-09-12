package com.java.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private BookService bookService;
    @Transactional
    @Override
    public void checkout(int[] bookIds, int userId) {
        for (Integer bookId : bookIds) {
            //调用service方法
            bookService.buyBook(bookId,userId);
        }
    }
}
