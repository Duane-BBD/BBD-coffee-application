package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.ProductResponseDTO;
import com.bbdsoftware.coffee.model.Availability;
import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.repository.AvailabilityRepository;
import com.bbdsoftware.coffee.repository.OfficeRepository;
import com.bbdsoftware.coffee.repository.ProductRepository;
import com.bbdsoftware.coffee.service.ProductService;
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
    public List<ProductResponseDTO> getAllProductDTOs() {
        List<Product> products = getAllProduct();
        return products.stream()
                .sorted(Comparator.comparingInt(Product::getProductID))
                .map(product -> {
                    ProductResponseDTO dto = new ProductResponseDTO();
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

//    @Override
//    public void deleteProduct(String productName) {
//        productRepository.deleteProduct(productName);
//    }
    @Override
    public Product getProduct(Integer productID) {
        return productRepository.findById(productID).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}



