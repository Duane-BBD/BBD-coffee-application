package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderDetailController {
    @Autowired
    OrderListService orderListService;

    public OrderDetailController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @GetMapping("{orderID}")
    public UserOrderList getOrderDetails(@PathVariable("orderID") Integer orderID) {
        return orderListService.getOrderDetails(orderID);
    }
}
