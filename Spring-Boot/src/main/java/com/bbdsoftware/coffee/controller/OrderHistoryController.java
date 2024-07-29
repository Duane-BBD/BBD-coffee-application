package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.OrderHistoryDTO;
import com.bbdsoftware.coffee.service.OrderHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bbd-coffee/order-history")
public class OrderHistoryController {
    @Autowired
    OrderHistoryService orderHistoryService;

    @GetMapping("/get-all-history")
    public ResponseEntity<List<OrderHistoryDTO>> getAllOrderHistories() {
        try {
            List<OrderHistoryDTO> orderHistories = orderHistoryService.getAllHistory()
                    .stream()
                    .map(OrderHistoryDTO::new)
                    .toList();;
            return new ResponseEntity<>(orderHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search-history/{userID}")
    public ResponseEntity<List<OrderHistoryDTO>> getOrderHistory(@PathVariable("userID") Integer userID){
        try {
            return new ResponseEntity<>(orderHistoryService.getOrderHistory(userID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
