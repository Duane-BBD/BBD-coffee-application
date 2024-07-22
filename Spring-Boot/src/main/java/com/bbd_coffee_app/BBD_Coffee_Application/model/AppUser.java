package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    private Integer userID;
    private String firstName;
    private String lastName;
    private int officeID;
    private int userStatusID;
    private int userTypeID;
    private Timestamp bannedUntil;
}
