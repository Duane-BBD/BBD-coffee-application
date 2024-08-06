package com.bbdsoftware.coffee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderHistoryID;
    private Integer orderID;
    @ManyToOne
    @JoinColumn(name="orderStatusID",referencedColumnName = "orderStatusID", nullable=false)
    private OrderStatus orderStatusID;
    @JsonFormat(pattern = "HH:mm:ss, dd-MM-yyyy")
    private Timestamp orderTime;
}
