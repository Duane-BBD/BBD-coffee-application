package com.bbdsoftware.coffee.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaristaDisplayDTO {
    private Integer orderID;
    private String productName;
    private Integer quantity;
    private String notes;
    private String milkTypeValue;
    @JsonFormat(pattern = "HH:mm:ss, dd-MM-yyyy")
    private Timestamp orderTime;
}
