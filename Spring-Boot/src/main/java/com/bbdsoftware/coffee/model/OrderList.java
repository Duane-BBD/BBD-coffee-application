package com.bbdsoftware.coffee.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer milkTypeID;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "officeID", nullable = false)
    private Office office;
}


