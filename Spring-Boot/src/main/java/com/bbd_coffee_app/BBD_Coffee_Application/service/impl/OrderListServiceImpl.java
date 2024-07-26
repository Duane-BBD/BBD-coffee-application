package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ReceiveOrderDetailDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.*;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
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
    OrderHistoryService orderHistoryService;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    AppUserService appUserService;

    public OrderListServiceImpl(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public OrderListDTO getOrderDetails(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);

        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("OrderID " + orderID + " does not exist!");
        }

        OrderList order = optional.get();
        OrderListDTO item = new OrderListDTO();
        item.setOrderID(orderID);
        item.setUserName(appUserRepository.findById(order.getUserID()).get().getFirstName() + " " + appUserRepository.findById(order.getUserID()).get().getLastName());
        item.setProductName(productRepository.findById(order.getProductID()).get().getProductName());
        item.setQuantity(order.getQuantity());
        item.setStatus(orderStatusRepository.findById(order.getOrderStatusID()).get().getOrderStatusValue());
        return item;
    }

    @Override
    public String updateOrderStatus(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);
        if(optional.isEmpty()){
            throw new ResourceNotFoundException("OrderID " + orderID + " does not exist!");
        }

        OrderList order = optional.get();
        return switch (order.getOrderStatusID()) {
            case 1, 2, 3 -> {
                if (orderID == 3 && isLate(orderID)) {
                    order.setOrderStatusID(5);
                    logHistory(order, orderID);
                    appUserService.banUser(order.getUserID());
                    orderListRepository.save(order);
                    yield "OrderID " + orderID + " was cancelled due to being late to receive the order!";
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

    public Boolean isLate(Integer orderID) {
        List<OrderHistory> allHistory = orderHistoryRepository.findAll();
        OrderHistory reqHistory = new OrderHistory();
        for(OrderHistory history : allHistory) {
            if(Objects.equals(history.getOrderID(), orderID))
                reqHistory = history;
        }
        long oneHourAgoMillis = reqHistory.getOrderTime().getTime() + (60 * 60 * 1000);
        return reqHistory.getOrderTime().getTime() <= oneHourAgoMillis && oneHourAgoMillis <= Timestamp.from(Instant.now()).getTime();
    }

    public void logHistory(OrderList order, Integer orderID) {
        OrderHistory entry = new OrderHistory();
        entry.setOrderID(order.getOrderID());
        OrderStatus data = new OrderStatus();
        data.setOrderStatusID(order.getOrderStatusID());
        entry.setOrderStatusID(data);
        entry.setOrderTime(Timestamp.from(Instant.now()));
        orderHistoryService.createHistory(entry);
    }

    @Override
    public void createOrder(List<ReceiveOrderDetailDTO> allOrderDetailDTO) {
        for (ReceiveOrderDetailDTO orderDetailDTO: allOrderDetailDTO) {
            OrderList newOrder = new OrderList();
            newOrder.setQuantity(orderDetailDTO.getQuantity());
            newOrder.setUserID(orderDetailDTO.getUserID());
            newOrder.setProductID(productRepository.findByProductName(orderDetailDTO.getProductName()));
            newOrder.setOrderStatusID(1);
            orderListRepository.save(newOrder);
            logHistory(newOrder, orderListRepository.findAll().size());
        }
//        orderListRepository.save(orderDetailDTO);
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
