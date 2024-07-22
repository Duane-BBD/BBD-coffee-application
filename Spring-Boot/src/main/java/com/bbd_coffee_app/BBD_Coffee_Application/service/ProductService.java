package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;

import java.util.List;

public interface ProductService {
    public List<String> productsAtOffice(Integer officeID);
    String createProduct(Product Product);
    String deleteProduct(Integer productID);
    Product getProduct(Integer productID);
    List<Product> getAllProduct();
}
