package com.example.springbootproduct.entity;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();


    public Cart(){}

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean checkItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry:products.entrySet()) {
            if(entry.getKey().getId() == product.getId()){
                return true;
            }
        }
        return  false;
    }
    public Map.Entry<Product,Integer> selectItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : products.entrySet()){
            if(entry.getKey().getId() == product.getId()){
                return  entry;
            }
        }
        return  null;
    }
    public void addProduct(Product product){
        if(!checkItemInCart(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> item = selectItemInCart((product));
            Integer newQuantity = item.getValue() + 1 ;
            products.replace(product,newQuantity);
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0 ;
        for (Map.Entry<Product,Integer> entry:products.entrySet()) {
             productQuantity += entry.getValue();
        }
        return  productQuantity;
    }
    public  Integer sizeProduct(){
        return  products.size();
    }

    public  Double countTotalPayment(){
        double payment = 0 ;
        for (Map.Entry<Product,Integer> entry: products.entrySet()){
             payment +=  (entry.getKey().getPrice() * entry.getValue());
        }
        return  payment;
    }

}
