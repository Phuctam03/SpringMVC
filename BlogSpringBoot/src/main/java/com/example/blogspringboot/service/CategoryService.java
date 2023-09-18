package com.example.blogspringboot.service;

import com.example.blogspringboot.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAll();
}
