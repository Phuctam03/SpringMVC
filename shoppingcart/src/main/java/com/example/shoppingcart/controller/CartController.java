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

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute( value = "cart",required = false)Cartdto cartdto){
        return  new ModelAndView("cart/list","cart",cartdto);
    }

    // not done
    @GetMapping("/add/{id}")
    public  ModelAndView increase(@SessionAttribute(value = "cart",required = false)Cartdto cartdto, @PathVariable String id){
        Product product = productService.findById(id);
        Productdto productdto = new Productdto();
        BeanUtils.copyProperties(product,productdto);
        cartdto.addProduct(productdto);
        return  new ModelAndView("redirect:/cart");
    }
    @GetMapping("/sub/{id}")
    public  ModelAndView decrease(@SessionAttribute(value = "cart",required = false)Cartdto cartdto, @PathVariable String id){
        Product product = productService.findById(id);
        Productdto productdto = new Productdto();
        BeanUtils.copyProperties(product,productdto);
        cartdto.decrease(productdto);
        return  new ModelAndView("redirect:/cart");
    }

}
