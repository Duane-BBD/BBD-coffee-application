package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {
    @Id
    private Integer orderHistoryID;
    private Integer orderID;
    private Integer orderStatusID;
    private Timestamp orderTime;

}
