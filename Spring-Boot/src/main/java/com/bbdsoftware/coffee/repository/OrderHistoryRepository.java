package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.model.OrderHistory;
import com.bbdsoftware.coffee.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
    @Query("SELECT orderHistoryID, orderID, orderStatusID, orderTime FROM OrderHistory o WHERE o.orderID = :orderID")
    List<OrderHistory> findHistoryByOrderId(Optional<OrderList> orderID);
}
