package com.example.blogspringboot.service;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImlp implements  BlogService{
    @Autowired
    private BlogRepository blogRepository ;
    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return blogRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
