package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order-list")
public class OrderListController {
    @Autowired
    OrderListService orderListService;

    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @PatchMapping("{orderID}")
    public String updateOrderStatus(@PathVariable Integer orderID) {
        return orderListService.updateOrderStatus(orderID);
    }
}
