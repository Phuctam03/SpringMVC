package com.example.applicationbook.controller;


import com.example.applicationbook.entity.Book;
import com.example.applicationbook.entity.UserBook;
import com.example.applicationbook.service.Bookservice;
import com.example.applicationbook.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private Bookservice bookservice;
    @Autowired
    private UserBookService userBookService;



    public String getFiveNumber(){
        Random random = new Random();
        int  id = random.nextInt(90000)+10000;
        String five = String.valueOf(id);
        return  five;
    }
    @GetMapping("/list")
    public ModelAndView listBook(){
        ModelAndView modelAndView = new ModelAndView("/book/listbook","books",bookservice.findAll());
        return  modelAndView;
    }


    // not done
    @GetMapping("/borrow")
    public ModelAndView detailBook(@RequestParam("id")int id){
        ModelAndView modelAndView = new ModelAndView("/book/detailBook","book",bookservice.findById(id));
        return  modelAndView;
    }

    @PostMapping("/borrow")
    public  ModelAndView  borrowBook(@ModelAttribute("book")Book book, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/book/list");
        try {
            if(book.getNumbers() == 0 ){
                redirectAttributes.addFlashAttribute("code","Library isn't book");
                return  modelAndView;
            }else {
                book.setNumbers(book.getNumbers() - 1);
                String id_user = getFiveNumber();
                userBookService.borrow(new UserBook(id_user,true,book));
                redirectAttributes.addFlashAttribute("code","code is :"+id_user );
            }
        }catch (Exception e){
              redirectAttributes.addFlashAttribute("code","library isn't this book");
              return  modelAndView;
        }
        return  modelAndView;
    }

    @GetMapping("/return")
    public ModelAndView listBorrow(){
        return  new ModelAndView("/book/listborrow","userBooks",userBookService.findAll());
    }



    // not done
    @PostMapping("/returnBook")
    public ModelAndView returnBook(@RequestParam("search")String id,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("book/listborrow");
        List<Book> bookList = bookservice.findAll();
        Book book = null;
        List<UserBook> userBookList = userBookService.findAll();
        for (UserBook userBook:userBookList) {
            if(userBook.getId().equals(id)){
                modelAndView.addObject("error","Book :"+userBook.getBook().getName()+" has been return");
                book = bookservice.findById(userBook.getBook().getId());
                book.setNumbers(userBook.getBook().getNumbers() + 1 );
                userBookService.deleteById(id);
                bookservice.create(book);
                modelAndView.addObject("userBooks",userBookService.findAll());
                return  modelAndView;
            }
        }
        modelAndView.addObject("userBooks",userBookService.findAll());
        modelAndView.addObject("error","not found id");
        return  modelAndView;
    }
}
