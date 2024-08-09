package com.bbdsoftware.coffee.DTO;

import lombok.Data;

@Data
public class ProductCreateDTO {
    private String productName;
    private String description;
    private String imageURL;
}