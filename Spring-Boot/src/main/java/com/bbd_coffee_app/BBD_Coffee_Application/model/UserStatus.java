package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="userStatus")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserStatus {
    @Id
    private Integer userStatusID;
    private String StatusValue;


}
