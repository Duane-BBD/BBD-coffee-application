package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.example.demo.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    OrderStatus getOrderStatus(Integer orderStatusID);
    List<OrderStatus> getAllOrderStatus();
}
