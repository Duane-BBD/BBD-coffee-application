package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
