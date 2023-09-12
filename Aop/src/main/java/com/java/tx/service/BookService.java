package com.java.tx.service;

public interface BookService {
    //买书的方法，图书id和用户id
    void buyBook(int bookId, int userId);
}
