package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.example.demo.model.OrderStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
