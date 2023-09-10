package com.example.applicationbook.repository;

import com.example.applicationbook.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserBookRepository extends JpaRepository<UserBook,String> {



}
