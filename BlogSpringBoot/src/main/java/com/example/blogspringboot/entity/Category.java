package com.example.blogspringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private  int id ;

    @Column(columnDefinition = "varchar(50)")
    private String name;


    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category(){}

    public Category(int id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
