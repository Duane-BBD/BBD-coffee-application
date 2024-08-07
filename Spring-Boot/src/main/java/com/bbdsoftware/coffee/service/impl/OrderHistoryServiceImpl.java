package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.OrderHistoryDTO;
import com.bbdsoftware.coffee.model.OrderHistory;
import com.bbdsoftware.coffee.model.OrderList;
import com.bbdsoftware.coffee.model.OrderStatus;
import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.repository.OrderHistoryRepository;
import com.bbdsoftware.coffee.repository.OrderListRepository;
import com.bbdsoftware.coffee.repository.OrderStatusRepository;
import com.bbdsoftware.coffee.service.MilkTypeService;
import com.bbdsoftware.coffee.service.OrderHistoryService;
import com.bbdsoftware.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    ProductService productService;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    MilkTypeService milkTypeService;

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
            hist.setNote(order.getNotes());
            hist.setMilkTypeValue(milkTypeService.getMilkType(order.getMilkTypeID()).getMilkTypeValue());
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

    @Override
    public List<OrderHistory> getOrderTime(Integer orderID) {
        List<OrderHistory> history = getAllHistory();
        List<OrderHistory> orderTime = new ArrayList<>();
        for(OrderHistory hist : history) {
            if (Objects.equals(hist.getOrderID(), orderID)) {
                orderTime.add(hist);
            }
        }
        return orderTime;
    }
}
