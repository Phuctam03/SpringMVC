package com.example.applicationbook.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class UserBook {
     @Id
    private  String id ;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "book_id")
    private Book book;


     private  boolean status;

     public UserBook(){}

    public UserBook(String id, boolean status, Book book) {
        this.id = id;
        this.book = book;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
