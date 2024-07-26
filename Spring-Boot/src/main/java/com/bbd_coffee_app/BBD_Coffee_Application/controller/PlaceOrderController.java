package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ReceiveOrderDetailDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place-order")
public class PlaceOrderController {
    @Autowired
    OrderListService orderListService;

    public PlaceOrderController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @PostMapping()
    public ResponseEntity<String> createAvailability(@RequestBody List<ReceiveOrderDetailDTO> receiveAllOrderDetailDTO) {
        try {
            orderListService.createOrder(receiveAllOrderDetailDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
