package com.bbdsoftware.coffee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserStatus {
    @Id
    private Integer userStatusID;
    private String StatusValue;
}
