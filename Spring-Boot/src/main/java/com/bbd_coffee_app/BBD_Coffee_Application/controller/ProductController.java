package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ProductCreateDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ProductResponseDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/office/{officeID}")
    public ResponseEntity<List<String>> getProductsAvailable(@PathVariable("officeID") Integer officeID) {
        List<String> products = productService.productsAtOffice(officeID);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
        List<ProductResponseDTO> productDTOs = productService.getAllProductDTOs();
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping("{productID}")
    public ResponseEntity<Product> getProduct(@PathVariable("productID") Integer productID) {
        Product product = productService.getProduct(productID);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productID") Integer productID) {
        productService.deleteProduct(productID);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setProductName(productCreateDTO.getProductName());
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
