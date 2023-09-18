package com.example.blogspringboot.entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private  int id;
    @Column(columnDefinition = "varchar(50)")
    private  String name;

    private  String subject;
    @Column(columnDefinition = "text")
    private  String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateContent;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;
    public Blog(){

    }
    public Blog(int id, String name, String subject, String content, Date dateContent) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.dateContent = dateContent;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateContent() {
        return dateContent;
    }

    public void setDateContent(Date dateContent) {
        this.dateContent = dateContent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

