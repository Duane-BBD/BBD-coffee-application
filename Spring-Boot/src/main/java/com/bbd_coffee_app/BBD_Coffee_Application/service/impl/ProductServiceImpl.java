package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ProductDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AvailabilityRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.ProductRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
            if (Objects.equals(A.getOfficeID().getOfficeID(), officeID)) {
                Integer prod = A.getProductID().getProductID();
                Optional<Product> optional = productRepository.findById(prod);
                optional.ifPresent(product -> productsAvailable.add(product.getProductName()));
            }
        }
        return productsAvailable;
    }

    @Override
    public List<ProductDTO> getAllProductDTOs() {
        List<Product> products = getAllProduct();
        return products.stream()
                .sorted(Comparator.comparingInt(Product::getProductID))
                .map(product -> {
                    ProductDTO dto = new ProductDTO();
                    dto.setProductID(product.getProductID());
                    dto.setProductName(product.getProductName());
                    return dto;
                }).collect(Collectors.toList());
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



