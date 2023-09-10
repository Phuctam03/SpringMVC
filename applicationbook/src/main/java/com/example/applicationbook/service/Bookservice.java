package com.example.applicationbook.service;

import com.example.applicationbook.entity.Book;
import com.example.applicationbook.entity.UserBook;

import java.util.List;

public interface Bookservice {

    void create(Book book);

    void deleteById(int id);

    List<Book> findAll();

    Book findById(int id);

}
