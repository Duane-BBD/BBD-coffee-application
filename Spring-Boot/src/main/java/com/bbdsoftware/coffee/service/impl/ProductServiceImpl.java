package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.model.Availability;
import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.repository.AvailabilityRepository;
import com.bbdsoftware.coffee.repository.OfficeRepository;
import com.bbdsoftware.coffee.repository.ProductRepository;
import com.bbdsoftware.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    AvailabilityRepository availabilityRepository;

    @Autowired
    OfficeRepository officeRepository;

    @Override
    public List<Product> productsAtOffice(Integer officeID) {
        List<Availability> allAvailabilities = availabilityRepository.findAll();
        List<Product> productsAvailable = new ArrayList<>();

        for (Availability A : allAvailabilities) {
            if (Objects.equals(A.getOfficeID().getOfficeID(), officeID)) {
                Integer prod = A.getProductID().getProductID();
                Optional<Product> optional = productRepository.findById(prod);
                optional.ifPresent(productsAvailable::add);
            }
        }
        return productsAvailable;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productID) {
        productRepository.deleteById(productID);
    }

//    @Override
//    public void deleteProduct(String productName) {
//        productRepository.deleteProduct(productName);
//    }

    @Override
    public Product getProduct(Integer productID) {
        Optional<Product> product = productRepository.findById(productID);
        return product.orElse(null);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}