package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderHistoryRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

//    @Override
//    public String createHistory(OrderHistory orderHistory) {
//        orderHistoryRepository.save(orderHistory);
//        return "Create Success!";
//    }

//    @Override
//    public OrderHistory getHistory(Integer orderHistoryID) {
//        return orderHistoryRepository.findById(orderHistoryID).get();
//    }

    @Override
    public List<OrderHistory> getAllHistory() {
        return orderHistoryRepository.findAll();
    }
}
