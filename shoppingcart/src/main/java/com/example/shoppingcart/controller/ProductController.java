package com.example.shoppingcart.controller;


import com.example.shoppingcart.dto.Cartdto;
import com.example.shoppingcart.dto.Productdto;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("product")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cartdto innitCartdto() {
        return new Cartdto();
    }

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView ListProduct() {
        return new ModelAndView("product/list", "products", productService.findAll());
    }

    @GetMapping("/detail")
    public ModelAndView detailProduct(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView("/product/detail", "product", productService.findById(id));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addToCart(@RequestParam("id") String id, @SessionAttribute(value = "cart", required = false) Cartdto cartdto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cart");
        Optional<Product> productOptional = Optional.ofNullable(productService.findById(id));
        if (productOptional.isPresent()) {
            Productdto productdto = new Productdto();
            BeanUtils.copyProperties(productOptional.get(), productdto);
            cartdto.addProduct(productdto);
        }
        return modelAndView;
    }


}
