package com.java.dao;

public interface BookDao {
    //根据图书的id查询图书的价格
    int getPriceByBookId(int bookId);
    //更新图书的库存
    int updateStock(int bookId);
    //更新用户的额余额
    int updateBalance(int userId, int price);
}
