package com.bbdsoftware.coffee.model;

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
    @ManyToOne
    @JoinColumn(name="officeID",referencedColumnName = "officeID",nullable = false)
    private Office officeID;
    @ManyToOne
    @JoinColumn(name="productID",referencedColumnName = "productID", nullable=false)
    private  Product productID;
}
