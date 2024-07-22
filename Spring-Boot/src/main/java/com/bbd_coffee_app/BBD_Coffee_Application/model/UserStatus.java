package com.example.demo.model;

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
