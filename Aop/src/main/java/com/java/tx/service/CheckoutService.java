package com.java.tx.service;

import org.springframework.transaction.annotation.Transactional;

public interface CheckoutService {
    BookService bookService = null;

    //买多本书的方法
    void checkout(int[] bookIds, int userId);
}
