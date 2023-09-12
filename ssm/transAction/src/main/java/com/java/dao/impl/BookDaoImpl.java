package com.java.dao.impl;

import com.java.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository()
public class BookDaoImpl implements BookDao {
    @Autowired()
    private JdbcTemplate jdbcTemplate;
    @Override
    public int getPriceByBookId(int bookId) {
        String sql="select price from t_book where book_id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class,bookId);
    }

    @Override
    public int updateStock(int bookId) {
        String sql="update t_book set stock=stock-1 where book_id=?";
        return jdbcTemplate.update(sql,bookId);
    }

    @Override
    public int updateBalance(int userId, int price) {
        String sql="update t_user set balance=balance-? where user_id=?";
        return jdbcTemplate.update(sql,price,userId);
    }
}
