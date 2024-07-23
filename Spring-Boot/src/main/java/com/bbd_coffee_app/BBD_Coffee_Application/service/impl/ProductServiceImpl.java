package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AvailabilityRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.ProductRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    AvailabilityRepository availabilityRepository;

    @Autowired
    OfficeRepository officeRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<String> productsAtOffice(Integer officeID) {
        List<Availability> allAvailabilities = availabilityRepository.findAll();
        List<String> productsAvailable = new ArrayList<String>();

        for (Availability A : allAvailabilities) {
            if (Objects.equals(A.getOfficeID(), officeID)) {
                Integer prod = A.getProductID().getProductID();
                Optional<Product> optional = productRepository.findById(prod);
                optional.ifPresent(product -> productsAvailable.add(product.getProductName()));
            }
        }
        return productsAvailable;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productID) {
        productRepository.deleteById(productID);
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


