package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ProductResponseDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;

import java.util.List;

public interface ProductService {
    public List<String> productsAtOffice(Integer officeID);
    Product createProduct(Product Product);
    void deleteProduct(Integer productID);
   // void deleteProduct(String productName);
//    void deleteByName(String productName);
    Product getProduct(Integer productID);
    List<Product> getAllProduct();
    List<ProductResponseDTO> getAllProductDTOs();

}
