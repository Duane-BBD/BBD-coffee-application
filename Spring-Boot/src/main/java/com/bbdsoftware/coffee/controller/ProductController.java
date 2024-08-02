package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.ProductCreateDTO;
import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bbd-coffee/products")
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/office-inventory/{officeID}")
    public ResponseEntity<List<String>> getProductsAvailable(@PathVariable("officeID") Integer officeID) {
        List<String> products = productService.productsAtOffice(officeID);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.getAllProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search-product/{productID}")
    public ResponseEntity<Product> getProduct(@PathVariable("productID") Integer productID) {
        Product product = productService.getProduct(productID);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete-product/{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productID") Integer productID) {
        productService.deleteProduct(productID);
        return ResponseEntity.ok().build();
    }

    @PostMapping("add-product")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setProductName(productCreateDTO.getProductName());
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
