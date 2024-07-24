package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    private String firstName;
    private String lastName;
    private int officeID;
    private int userStatusID;
    private int userTypeID;
    private Timestamp bannedUntil;

    @ManyToOne
    @JoinColumn(name = "userTypeID", insertable = false, updatable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "officeID", insertable = false, updatable = false)
    private Office office;
}
