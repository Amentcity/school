package com.java.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //根据图书的id查询图书的价格
    @Override
    public int getBookPriceByBookId(int bookId) {
        String sql="select price from t_book where book_id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
    }
    //更新图书表库存量-1
    @Override
    public void updateStock(int bookId) {
        String sql="update t_book set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql,bookId);

    }
    //更新用户表用户余额-图书价格
    @Override
    public void updateUserBalance(int userId, int price) {
        String sql="update t_user set balance=balance-? where user_id=?";
        jdbcTemplate.update(sql,price,userId);
    }
}
