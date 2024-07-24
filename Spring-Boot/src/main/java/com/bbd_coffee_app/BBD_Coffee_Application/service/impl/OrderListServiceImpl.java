package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.*;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
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

    @Autowired
    OrderHistoryService orderHistoryRepository;

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
    public String updateOrderStatus(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);

        if(optional.isPresent()) {
            OrderList order = optional.get();
            return switch (order.getOrderStatusID()) {
                case 1, 2, 3 -> {
                    if (isLate(orderID)) {
                        order.setOrderStatusID(5);
                        logHistory(order, orderID);
                        yield "OrderID " + orderID + "was cancelled due to being late to receive the order!";
                    }
                    order.setOrderStatusID(order.getOrderStatusID() + 1);
                    logHistory(order, orderID);
                    orderListRepository.save(order);
                    yield "Updated!";
                }
                case 4 -> "Order " + orderID + " is complete!";
                default -> "Order " + orderID + " was cancelled!";
            };
        }
        return "OrderID " + orderID + " does not exist!";
    }

    public Boolean isLate(Integer orderID) {
        return false;
    }

    public void logHistory(OrderList order, Integer orderID) {
        OrderHistory entry = new OrderHistory();
        entry.setOrderID(orderID);
        OrderStatus data = new OrderStatus();
        Optional<OrderStatus> state = orderStatusRepository.findById(order.getOrderStatusID());
        data.setOrderStatusID(order.getOrderStatusID());
        entry.setOrderStatusID(data);
        Timestamp time = Timestamp.from(Instant.now());
        entry.setOrderTime(time);
        orderHistoryRepository.createHistory(entry);
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
