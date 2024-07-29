package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbd-coffee/orders")
public class OrderDetailController {
    @Autowired
    OrderListService orderListService;

    public OrderDetailController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @GetMapping("/get-order-details/{orderID}")
    public ResponseEntity<OrderListDTO> getOrderDetails(@PathVariable("orderID") Integer orderID) {
        try {
            return new ResponseEntity<>(orderListService.getOrderDetails(orderID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
