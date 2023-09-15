package com.example.shoppingcart.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

public class Productdto {
    private String id;
    private String name;

    private double price;

    private String image;

    public Productdto() {
    }

    public Productdto(String id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Productdto productdto = (Productdto) obj;
        return id.equals(productdto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
