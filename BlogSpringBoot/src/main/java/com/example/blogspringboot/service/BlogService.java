package com.example.blogspringboot.service;

import com.example.blogspringboot.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void create(Blog blog);
    void  update(Blog blog);
    void delete(int id );
    Blog findById(int id);
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAllByName(String name);
    List<Blog> findAll();
}
