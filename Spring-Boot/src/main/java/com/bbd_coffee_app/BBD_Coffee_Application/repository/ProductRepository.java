package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
