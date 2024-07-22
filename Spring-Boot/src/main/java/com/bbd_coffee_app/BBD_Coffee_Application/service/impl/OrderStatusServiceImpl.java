package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderStatusRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderStatus getOrderStatus(Integer orderStatusID){
       return orderStatusRepository.findById(orderStatusID).get();
    }

    @Override
    public List<OrderStatus> getAllOrderStatus(){
        return orderStatusRepository.findAll();
    }
}
