package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderHistoryDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderHistoryService {
    public void createHistory(OrderHistory orderHistory);
//     List<OrderHistory> getHistory(Integer orderHistoryID);
     List<OrderHistory> getAllHistory();
     List<OrderHistoryDTO> getOrderHistory(Integer orderID);
}
