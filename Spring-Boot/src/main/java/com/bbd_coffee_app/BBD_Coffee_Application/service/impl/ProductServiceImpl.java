package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.ProductRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String createProduct(Product Product) {
         productRepository.save(Product);
        return "product created";

    }

    @Override
    public String deleteProduct(Integer productID) {
        productRepository.deleteById(productID);
        return "product deleted";
    }

    @Override
    public Product getProduct(Integer productID) {
        return productRepository.findById(productID).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}