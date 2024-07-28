package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderHistoryDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderHistoryRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderStatusRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    OrderListRepository orderListRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProductService productService;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }
//    @Override
//    public List<OrderHistory> getHistory(Integer orderHistoryID) {
//        return orderHistoryRepository.findById(orderHistoryID);
//    }

    @Override
    public List<OrderHistory> getAllHistory() {
        return orderHistoryRepository.findAll();
    }

    @Override
    public void createHistory(OrderHistory orderHistory) {
        orderHistoryRepository.save(orderHistory);
    }
    @Override
    public List<OrderHistoryDTO> getOrderHistory(Integer userID){
        List<OrderHistoryDTO> userHistory = new ArrayList<>();
        List<OrderList> orders = orderListRepository.findAll();
        List<OrderList> reqOrders = new ArrayList<>();
        for (OrderList order : orders) {
            if (Objects.equals(order.getUserID(), userID)) {
                reqOrders.add(order);
            }
        }
        for (OrderList order: reqOrders) {
            OrderHistoryDTO hist = new OrderHistoryDTO();
            List<OrderHistory> history = orderHistoryRepository.findAll();
            Optional<OrderList> optional1 = orderListRepository.findById(order.getOrderID());
            if (optional1.isEmpty()) {
                return null;
            }
            for (OrderHistory time : history) {
                if(Objects.equals(time.getOrderID(), optional1.get().getOrderID())) {
                    if (Objects.equals(time.getOrderID(), order.getOrderID())) {
                        hist.setOrderTime(time.getOrderTime());
                    }
                }

            }
            Product prod = productService.getProduct(order.getProductID());
            hist.setOrderID(order.getOrderID());
            hist.setProductName(prod.getProductName());
            hist.setQuantity(order.getQuantity());
            Optional<OrderStatus> optional = orderStatusRepository.findById(order.getOrderStatusID());
            if (optional.isEmpty()) {
                return null;
            }
            hist.setOrderStatusValue(optional.get().getOrderStatusValue());
            userHistory.add(hist);
        }
//                .stream()
//                .map(order -> modelMapper.map(order, OrderHistoryDTO.class))
//                .collect(Collectors.toList());
        return userHistory;
    }
}
