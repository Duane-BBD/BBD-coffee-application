package com.bbd_coffee_app.BBD_Coffee_Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveOrderDetailDTO {
//    private Integer orderID;
    private String productName;
    private Integer quantity;
    private Integer userID;
    private Integer officeID;
}
