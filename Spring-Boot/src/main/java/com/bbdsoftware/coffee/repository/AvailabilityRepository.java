package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
//    @Query("SELECT p FROM Product p WHERE p.productName == :productName")
//    Product findByProductName(String productName);
//    @Query("SELECT * FROM Availability a WHERE a.officeID = :officeID")
//    List<Availability> findByOrderId(Integer officeID);
}
