package com.java.tx.dao;

public interface BookDao {
    //根据图书的id查询图书的价格
    int getBookPriceByBookId(int bookId);
    //根据图书的id查询图书的价格
    void updateStock(int bookId);
    //更新用户表用户余额-图书价格
    void updateUserBalance(int userId, int price);
}
