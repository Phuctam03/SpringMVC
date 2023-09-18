package com.example.blogspringboot.repository;


import com.example.blogspringboot.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository  extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByNameContaining(String name);

}
