package com.example.blogspringboot.controller;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.service.BlogService;
import com.example.blogspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/home")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("Blog/Home");
        return modelAndView;
    }

    @GetMapping("/listPaging")
    public ModelAndView displayBlog(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("sort") Optional<String> sort
    ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        String sortField = sort.orElse("dateContent");
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending());
        Page<Blog> Blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("Blog/list", "Blogs", Blogs);
        int totalPage = Blogs.getTotalPages();
        if (totalPage > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detailBlog(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("Blog/detail", "blog", blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("Blog/createOrUpdate", "Blog", new Blog());
        modelAndView.addObject("action", "create");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView formUpdate(@RequestParam("id") int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("Blog/createOrUpdate", "Blog", blog);
        modelAndView.addObject("action", "update");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/createOrUpdate")
    public ModelAndView createOrUpdate(@ModelAttribute("Blog") Blog blog, @RequestParam("action") String action) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/listPaging");
        if ("create".equalsIgnoreCase(action)) {
            blogService.create(blog);
        } else {
            blogService.update(blog);
        }
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteBlog(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/listPaging");
        blogService.delete(id);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchBlog(@RequestParam("name") String name,
                                   @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size,
                                   @RequestParam("sort") Optional<String> sort) {
        ModelAndView modelAndView = new ModelAndView("Blog/list");
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        String sortField = sort.orElse("dateContent");
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending());
        Page<Blog> Blogs = blogService.findAll(pageable);
        int totalPage = Blogs.getTotalPages();
        modelAndView.addObject("Blogs", blogService.findAllByName(name));
        if (totalPage > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        return modelAndView;
    }
}
