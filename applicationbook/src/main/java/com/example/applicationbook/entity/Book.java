package com.example.applicationbook.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private  int id;

    @Column(columnDefinition = "varchar(50)")
    private  String name;
    @Column(columnDefinition = "varchar(50)")
    private  String author;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date realasedate;

    private  int numbers;



    public  Book(){

    }
    public Book(int id, String name, String author, Date realasedate,int numbers) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.realasedate = realasedate;
        this.numbers = numbers;
    }

    public Book(int id, String name, String author, Date realasedate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.realasedate = realasedate;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getRealasedate() {
        return realasedate;
    }

    public void setRealasedate(Date realasedate) {
        this.realasedate = realasedate;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}
