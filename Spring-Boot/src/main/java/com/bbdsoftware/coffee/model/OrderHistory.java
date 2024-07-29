package com.bbdsoftware.coffee.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderHistoryID;
    private Integer orderID;
    @ManyToOne
    @JoinColumn(name="orderStatusID",referencedColumnName = "orderStatusID", nullable=false)
    private OrderStatus orderStatusID;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp orderTime;
}
