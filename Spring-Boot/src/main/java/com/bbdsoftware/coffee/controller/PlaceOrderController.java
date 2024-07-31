package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.ReceiveOrderDetailDTO;
import com.bbdsoftware.coffee.service.OrderListService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("bbd-coffee")
public class PlaceOrderController {
    @Autowired
    OrderListService orderListService;

    @PostMapping("/order-creation")
    public ResponseEntity<String> placeOrder(@RequestBody List<ReceiveOrderDetailDTO> receiveAllOrderDetailDTO) {
        try {
            return new ResponseEntity<>(orderListService.createOrder(receiveAllOrderDetailDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
