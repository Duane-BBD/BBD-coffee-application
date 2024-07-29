package com.bbdsoftware.coffee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="office")
public class Office {
    @Id
    @GeneratedValue(generator = "office_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name= "office_gen",sequenceName= "office_seq",allocationSize = 1)
    private Integer officeID;
    @OneToMany(mappedBy="officeID")
    private Set<Availability> officeId;
    private String officeName;
    @OneToMany(mappedBy = "office")
    @JsonIgnore
    private Set<OrderList> orderLists;


    public Office(Integer officeID, String officeName) {
        this.officeID = officeID;
        this.officeName = officeName;
    }
}
