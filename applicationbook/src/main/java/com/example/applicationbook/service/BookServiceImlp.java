package com.example.applicationbook.service;

import com.example.applicationbook.entity.Book;
import com.example.applicationbook.entity.UserBook;
import com.example.applicationbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImlp implements Bookservice {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void create(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return  bookRepository.findById(id).orElse(null);
    }


}
