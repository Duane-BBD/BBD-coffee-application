package com.bbd_coffee_app.BBD_Coffee_Application.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="office")
public class Office {
    @Id
    @GeneratedValue(generator = "office_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name= "office_gen",sequenceName= "office_seq",allocationSize = 1)//write bbdcoffee.office
    private Integer officeID;
    private String officeName;

}
