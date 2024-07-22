package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    OrderListRepository orderListRepository;

    public OrderListServiceImpl(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public String createOrder(OrderList orderList) {
        orderListRepository.save(orderList);
        return "Create Success!";
    }

    @Override
    public String updateOrder(OrderList orderList, Integer orderID) {
        return "";
    }

//    @Override
//    public String updateOrder(OrderList orderList, Integer appUserID) {
//        // updating one field
//        OrderList order = orderListRepository.findById(orderID).orElseThrow();
//
//
//        orderListRepository.save(orderID);
//        return "Update Success!";
//    }

    @Override
    public String deleteOrder(Integer orderID) {
        orderListRepository.deleteById(orderID);
        return "Delete Success!";
    }

    @Override
    public OrderList getOrder(Integer orderID) {
        return orderListRepository.findById(orderID).get();
    }

    @Override
    public List<OrderList> getAllOrders() {
        return orderListRepository.findAll();
    }
}
