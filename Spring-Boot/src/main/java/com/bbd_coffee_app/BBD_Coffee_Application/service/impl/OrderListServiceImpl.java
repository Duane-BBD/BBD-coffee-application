package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AppUserRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderStatusRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.ProductRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    OrderListRepository orderListRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    public OrderListServiceImpl(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public OrderListDTO getOrderDetails(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);

        if (optional.isPresent()) {
            OrderList order = optional.get();
            OrderListDTO item = new OrderListDTO();
            item.setOrderID(orderID);
            item.setUserName(appUserRepository.findById(order.getUserID()).get().getFirstName() + " " + appUserRepository.findById(order.getUserID()).get().getLastName());
            item.setProductName(productRepository.findById(order.getProductID()).get().getProductName());
            item.setQuantity(order.getQuantity());
            item.setStatus(orderStatusRepository.findById(order.getOrderStatusID()).get().getOrderStatusValue());
            return item;
        }
        else {
            return null;
        }
    }

    @Override
    public String createOrder(OrderList orderList) {
        orderListRepository.save(orderList);
        return "Create Success!";
    }

    @Override
    public String updateOrder(OrderList orderList, Integer orderID) {
        return "Update Success!";
    }

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
