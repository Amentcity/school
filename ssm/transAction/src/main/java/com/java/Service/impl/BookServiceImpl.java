package com.java.Service.impl;


import com.java.Service.BookService;
import com.java.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(int userId, int bookId) {
        //查询图书的操作
        int price = bookDao.getPriceByBookId(bookId);
        //跟新图书的库存
        int i1 = bookDao.updateStock(bookId);
        //更新用户的余额
        int i = bookDao.updateBalance(userId, price);

    }
}
