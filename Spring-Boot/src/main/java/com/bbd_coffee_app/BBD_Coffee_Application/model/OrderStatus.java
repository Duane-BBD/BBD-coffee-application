package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    @Id
    private Integer orderStatusID;
    private String orderStatusValue;
}
