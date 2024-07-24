package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderHistoryDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/order-history")
public class OrderHistoryController {
    @Autowired
    OrderHistoryService orderHistoryService;

    @GetMapping("/")
    public ResponseEntity<List<OrderHistoryDTO>> getAllOrderHistories() {
        try {
            List<OrderHistoryDTO> orderHistories = orderHistoryService.getAllHistory();
            return new ResponseEntity<>(orderHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{orderID}")
    public ResponseEntity<List<OrderHistoryDTO>> getorderHistory(@PathVariable("orderID") Integer orderID){
        try {
            return new ResponseEntity<>(orderHistoryService.getOrderHistory(orderID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
