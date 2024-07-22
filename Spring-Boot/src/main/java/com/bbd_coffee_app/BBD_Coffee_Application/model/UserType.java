package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserType {
    @Id
    private Integer userTypeID;
    private String userTypeValue;
}