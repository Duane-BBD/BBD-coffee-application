package com.bbd_coffee_app.BBD_Coffee_Application.DTO;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AvailabilityDTO {
//    private Integer availabilityID;
//    private Integer officeID;
    private String productName;
    private String officeName;



    public AvailabilityDTO(Availability availability) {
//        this.availabilityID = availability.getAvailabilityID();
//        this.officeID = availability.getOfficeID().getOfficeID();
        this.productName = availability.getProductID().getProductName();
        this.officeName=availability.getOfficeID().getOfficeName();
    }

}
