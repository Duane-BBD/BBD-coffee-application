package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    String createProduct(Product Product);
    String deleteProduct(Integer productID);
    Product getProduct(Integer productID);
    List<Product> getAllProduct();
}
