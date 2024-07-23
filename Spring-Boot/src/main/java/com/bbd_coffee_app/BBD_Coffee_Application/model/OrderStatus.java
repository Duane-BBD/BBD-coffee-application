package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Table(name="orderStatus")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderStatusID;
    private String orderStatusValue;
    @OneToMany(mappedBy="orderStatusID")
    private Set<OrderStatus> orderStatusId;
}
