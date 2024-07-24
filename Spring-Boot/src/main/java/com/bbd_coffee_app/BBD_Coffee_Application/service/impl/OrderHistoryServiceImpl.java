package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderHistoryDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderHistoryRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }
//    @Override
//    public List<OrderHistory> getHistory(Integer orderHistoryID) {
//        return orderHistoryRepository.findById(orderHistoryID);
//    }

    @Override
    public List<OrderHistoryDTO> getAllHistory() {
        List<OrderHistory> orderHistory= orderHistoryRepository.findAll();
        return   orderHistory.stream()
                .map(OrderHistoryDTO::new)
                .toList();
    }

    @Override
    public String createHistory(OrderHistory orderHistory) {
        orderHistoryRepository.save(orderHistory);
        return "Create Success!";
    }
    @Override
    public List<OrderHistoryDTO> getOrderHistory(Integer orderID){
        return orderHistoryRepository.findByOrderId(orderID)
                .stream()
                .map(order ->{
                    return modelMapper.map(order, OrderHistoryDTO.class);
                })
                .collect(Collectors.toList());
    }
}
