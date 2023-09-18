package com.example.blogspringboot.controller;


import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.Category;
import com.example.blogspringboot.service.BlogService;
import com.example.blogspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/blog")
public class RestController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }
    @GetMapping("/listblog")
    public ResponseEntity<List<Blog>> findAllBlog(){
        List<Blog> blogs = blogService.findAll();
        if(blogs.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Blog> detailBlog(@PathVariable("id")int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }

    }

}
