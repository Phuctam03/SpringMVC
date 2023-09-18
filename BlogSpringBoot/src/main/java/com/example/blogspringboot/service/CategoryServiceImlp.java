package com.example.blogspringboot.service;

import com.example.blogspringboot.entity.Category;
import com.example.blogspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImlp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
