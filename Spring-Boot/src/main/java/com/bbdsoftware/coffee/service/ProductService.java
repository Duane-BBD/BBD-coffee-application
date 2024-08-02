package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.Product;

import java.util.List;

public interface ProductService {
    List<String> productsAtOffice(Integer officeID);
    void createProduct(Product Product);
    void deleteProduct(Integer productID);
//    void deleteProduct(String productName);
//    void deleteByName(String productName);
    Product getProduct(Integer productID);
    List<Product> getAllProduct();
}
