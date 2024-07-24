package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
//    @Query("SELECT p FROM Product p WHERE p.productName == :productName")
//    Product findByProductName(String productName);
//    @Query("SELECT * FROM Availability a WHERE a.officeID = :officeID")
//    List<Availability> findByOrderId(Integer officeID);
}
