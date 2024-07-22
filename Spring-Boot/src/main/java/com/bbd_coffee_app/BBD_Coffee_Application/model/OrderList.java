package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
    @Id
    private Integer orderID;
    private Integer productID;
    private Integer orderStatusID;
    private Integer quantity;
    private Integer userID;

}
