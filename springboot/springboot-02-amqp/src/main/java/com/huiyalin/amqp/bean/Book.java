package com.huiyalin.amqp.bean;

public class Book {

    private String BookName;
    private String author;

    public Book(String bookName, String author) {
        BookName = bookName;
        this.author = author;
    }

    public Book() {
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

    @Override
    public String toString() {
        return "Book{" +
                "BookName='" + BookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
