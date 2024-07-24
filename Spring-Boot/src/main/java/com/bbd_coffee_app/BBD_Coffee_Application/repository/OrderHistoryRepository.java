package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
    @Query("SELECT o FROM OrderHistory o WHERE o.orderID = :orderID")
    List<OrderHistory> findByOrderId(Integer orderID);
}
