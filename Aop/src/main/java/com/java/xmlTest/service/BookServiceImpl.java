package com.java.xmlTest.service;

import com.java.xmlTest.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(int bookId, int userId) {
//        //TODO 模拟超时效果
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //根据图书的id查询图书的价格
        int price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量-1
        bookDao.updateStock(bookId);
        //更新用户表用户余额-图书价格
        bookDao.updateUserBalance(userId, price);
    }
}
