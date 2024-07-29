package com.bbdsoftware.coffee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class BaristaDisplayDTO {
    private Integer orderID;
    private String productName;
    private Integer quantity;
}
