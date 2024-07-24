package com.bbd_coffee_app.BBD_Coffee_Application.DTO;


import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryDTO {
    private Integer orderID;
    private String orderStatusValue;
    private Timestamp orderTime;
    public OrderHistoryDTO(OrderHistory orderHistory) {
        this.orderID = orderHistory.getOrderID();
        this.orderStatusValue = String.valueOf(orderHistory.getOrderStatusID());
        this.orderTime=orderHistory.getOrderTime();
    }
}
