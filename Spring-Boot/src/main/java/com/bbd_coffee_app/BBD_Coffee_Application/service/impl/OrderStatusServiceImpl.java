package com.example.demo.service.impl;

import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;
import com.example.demo.service.OrderStatusService;
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
