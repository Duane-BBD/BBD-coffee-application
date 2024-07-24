package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.AvailabilityDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;

import java.util.List;

public interface AvailabilityService {
//    public String createAvailability(Availability availability);
//    public String deleteAvailability(Integer availabilityID);
//    public Availability getAvailability(Integer availabilityID);
     List<AvailabilityDTO> getAllAvailability();
     void createAvailability(AvailabilityDTO availabilityDTO);
//     List<AvailabilityDTO> getAvailabilityByID(Integer officeID);

}
