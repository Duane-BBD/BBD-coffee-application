package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;
    private Integer productID;
    private Integer orderStatusID;
    private Integer quantity;
    private Integer userID;
//    private Integer officeID;

    @ManyToOne
    @JoinColumn(name = "officeID", nullable = false)
    private Office office;
}


