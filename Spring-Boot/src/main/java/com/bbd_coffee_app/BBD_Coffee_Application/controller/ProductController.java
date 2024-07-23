package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ProductDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{officeID}")
    public List<String> getProductsAvailable(@PathVariable("officeID") Integer officeID) {
        return productService.productsAtOffice(officeID);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllOffice() {
        try {
            List<Product> product = productService.getAllProduct();
            List<ProductDTO> productDTOs = product.stream()
                    .sorted((o1, o2) -> Integer.compare(o1.getProductID(), o2.getProductID()))
                    .map(office -> {
                        ProductDTO dto = new ProductDTO();
                        dto.setProductID(office.getProductID());
                        dto.setProductName(office.getProductName());
                        return dto;
                    }).collect(Collectors.toList());

            return new ResponseEntity<>(productDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productID") Integer productID) {
        try {
            productService.deleteProduct(productID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
