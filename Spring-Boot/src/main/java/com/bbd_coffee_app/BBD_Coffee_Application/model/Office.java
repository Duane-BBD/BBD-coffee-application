package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @Id
    private Integer officeID;
    private String officeName;

}
