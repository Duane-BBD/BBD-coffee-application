package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order-list")
public class OrderListController {
    @Autowired
    OrderListService orderListService;

    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @PatchMapping("{orderID}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Integer orderID) {
        try {
            return new ResponseEntity<>(orderListService.updateOrderStatus(orderID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{orderID}/office/{officeID}")
    public ResponseEntity<List<OrderListDTO>> getOrderDetails(@PathVariable("orderID") Integer orderID, @PathVariable("officeID") Integer officeID) {
        try {
            return new ResponseEntity<>(orderListService.getOrderDetails(orderID, officeID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
