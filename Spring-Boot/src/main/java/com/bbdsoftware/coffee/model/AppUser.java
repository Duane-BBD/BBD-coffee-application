package com.bbdsoftware.coffee.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appUser")
public class AppUser {
    @Id
    private Integer userID;
    private String firstName;
    private String lastName;
    private Integer officeID;
    private Integer userStatusID;
    private Integer userTypeID;
    private Timestamp bannedUntil;

    @ManyToOne
    @JoinColumn(name = "userTypeID", insertable = false, updatable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "officeID", insertable = false, updatable = false)
    private Office office;

    public AppUser(Integer userID, String firstName, String lastName, Integer id, Integer userStatusID, Integer userTypeID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeID = id;
        this.userStatusID = userStatusID;
        this.userTypeID = userTypeID;
    }
}
