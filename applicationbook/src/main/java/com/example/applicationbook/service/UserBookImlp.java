package com.example.applicationbook.service;

import com.example.applicationbook.entity.UserBook;
import com.example.applicationbook.repository.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserBookImlp  implements  UserBookService{

    @Autowired
    private UserBookRepository userBookRepository;

    @Override
    public void borrow(UserBook userBook) {
        userBookRepository.save(userBook);

    }

    @Override
    public List<UserBook> findAll() {
        return userBookRepository.findAll();
    }

    @Override
    public UserBook findById(String id) {
        return userBookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
          userBookRepository.deleteById(id);
    }


}
