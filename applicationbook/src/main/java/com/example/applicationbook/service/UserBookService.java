package com.example.applicationbook.service;

import com.example.applicationbook.entity.UserBook;

import java.util.List;

public interface UserBookService {

    void borrow(UserBook userBook);

    List<UserBook> findAll();

    UserBook findById(String id );

    void deleteById(String id );


}
