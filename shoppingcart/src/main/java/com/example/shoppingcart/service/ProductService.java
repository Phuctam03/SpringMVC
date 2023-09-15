package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(String id);

}
