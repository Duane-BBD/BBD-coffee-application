package com.bbdsoftware.coffee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserOfficeDTO {
        private String firstName;
        private String lastName;
        private String userTypeValue;//String previously
        private String officeName;

//        public UserOfficeDTO(String officeName, String firstName, String lastName) {
//                this.officeName = officeName;
//                this.firstName = firstName;
//                this.lastName = lastName;
//        }
}
