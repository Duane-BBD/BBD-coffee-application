package com.bbd_coffee_app.BBD_Coffee_Application.DTO;


import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "HH:mm:ss, dd-MM-yyyy")
    private Timestamp orderTime;
    public OrderHistoryDTO(OrderHistory orderHistory) {
        this.orderID = orderHistory.getOrderID();
        this.orderStatusValue = orderHistory.getOrderStatusID().getOrderStatusValue();
        this.orderTime=orderHistory.getOrderTime();
    }
}
