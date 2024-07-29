package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.DTO.AvailabilityDTO;

import java.util.List;

public interface AvailabilityService {
//    public String createAvailability(Availability availability);
//    public String deleteAvailability(Integer availabilityID);
//    public Availability getAvailability(Integer availabilityID);
     List<AvailabilityDTO> getAllAvailability();
     void createAvailability(AvailabilityDTO availabilityDTO);
//     List<AvailabilityDTO> getAvailabilityByID(Integer officeID);

}
