package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    public String createHistory(OrderHistory orderHistory);
    public OrderHistory getHistory(Integer orderHistoryID);
    public List<OrderHistory> getAllHistory();
}
