package com.bbd_coffee_app.BBD_Coffee_Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class BaristaDisplayDTO {
    private Integer orderID;
    private String productName;
    private Integer quantity;
}
