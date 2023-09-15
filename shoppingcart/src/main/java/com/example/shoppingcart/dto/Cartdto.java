package com.example.shoppingcart.dto;

import com.example.shoppingcart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Cartdto {

    private  static Map<Productdto,Integer> products = new HashMap<>();

    public  Cartdto(){}

    public  Map<Productdto, Integer> getProducts() {
        return products;
    }

    public  void setProducts(Map<Productdto, Integer> products) {
        Cartdto.products = products;
    }

    public   void addProduct(Productdto productdto){
         if(!products.containsKey(productdto)){
             products.put(productdto,1);
         }else {
             Integer newQuantity = products.get(productdto) + 1 ;
             products.replace(productdto,newQuantity);
         }
    }

    public  void decrease(Productdto productdto){
        Integer value = products.get(productdto);
        if(value > 1 ){
            products.put(productdto,value - 1);
        }

    }
    public  Double totalPayment(){
        double payment = 0 ;
        for (Map.Entry<Productdto,Integer> entry:products.entrySet()){
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
