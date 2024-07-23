package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer availabilityID;
    @JoinColumn(name="officeID",referencedColumnName = "officeID",nullable = false)
    @ManyToOne
    private Office officeID;
    @ManyToOne
    @JoinColumn(name="productID",referencedColumnName = "productID", nullable=false)
    private  Product productID;

}
