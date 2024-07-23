package com.bbd_coffee_app.BBD_Coffee_Application.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderList {
    @Id
    private Integer orderID;
    private String userName;
    private String productName;
    private int quantity;
    private String status;
}