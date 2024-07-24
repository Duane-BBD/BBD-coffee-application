package com.bbd_coffee_app.BBD_Coffee_Application.DTO;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class UserRegisterDTO {
    private String firstName;
    private String lastName;
    private Integer userID;
    private String officeName;


}



