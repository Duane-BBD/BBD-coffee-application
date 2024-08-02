package com.bbdsoftware.coffee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="milkType")
public class MilkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer milkTypeID;
    String milkTypeValue;
}
