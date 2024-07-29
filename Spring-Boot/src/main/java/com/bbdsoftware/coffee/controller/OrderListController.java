package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bbd-coffee/order-list")
public class OrderListController {
    @Autowired
    OrderListService orderListService;

    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @PatchMapping("/update-status/{orderID}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Integer orderID) {
        try {
            return new ResponseEntity<>(orderListService.updateOrderStatus(orderID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search-office/{officeID}")
    public ResponseEntity<List<OrderListDTO>> getOrderDetailsByOfficeID(@PathVariable("officeID") Integer officeID) {
        try {
            return new ResponseEntity<>(orderListService.getOrderDetailsByOfficeID(officeID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/past-orders/{userID}")
    public ResponseEntity<List<OrderListDTO>> getPastOrders(@PathVariable("userID") Integer userID) {
        try {
            return new ResponseEntity<>(orderListService.pastOrders(userID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
