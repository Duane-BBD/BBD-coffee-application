package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderHistoryService {
//    public String createHistory(OrderHistory orderHistory);
//     List<OrderHistory> getHistory(Integer orderHistoryID);
     List<OrderHistory> getAllHistory();
}
