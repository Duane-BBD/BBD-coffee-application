package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    OrderStatus getOrderStatus(Integer orderStatusID);
    List<OrderStatus> getAllOrderStatus();
}
