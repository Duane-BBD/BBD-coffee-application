package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.service.OrderListService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/bbd-coffee/orders")
public class OrderDetailController {
    @Autowired
    OrderListService orderListService;

    @GetMapping("/get-order-details/{orderID}")
    public ResponseEntity<OrderListDTO> getOrderDetails(@PathVariable("orderID") Integer orderID) {
        try {
            return new ResponseEntity<>(orderListService.getOrderDetails(orderID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
