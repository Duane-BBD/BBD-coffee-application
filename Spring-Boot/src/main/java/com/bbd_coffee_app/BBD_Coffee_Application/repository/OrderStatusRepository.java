package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
