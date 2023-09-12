package com.java.di;

public class Book {
    private String BookName;
    private String author;

    private String others;

    public Book(String BookName, String author) {
        System.out.println("有参数构造方法执行了");
        this.BookName = BookName;
        this.author = author;
    }

    public Book() {
        System.out.println("无参数构造方法执行了");
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookName='" + BookName + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}
