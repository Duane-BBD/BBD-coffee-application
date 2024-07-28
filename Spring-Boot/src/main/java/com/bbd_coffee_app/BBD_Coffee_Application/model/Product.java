package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name= "product_gen",sequenceName= "product_seq",initialValue = 7, allocationSize = 1)
    private Integer productID;
    private String productName;
    //new
//    @ManyToOne
//    @JoinColumn(name = "orderStatusID")
//    private OrderStatus orderStatus;
}
