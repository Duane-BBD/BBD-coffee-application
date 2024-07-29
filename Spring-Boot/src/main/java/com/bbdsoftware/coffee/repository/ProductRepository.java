package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT productID From Product p where productName=:productName ")
    Integer findByProductName(String productName);
}
