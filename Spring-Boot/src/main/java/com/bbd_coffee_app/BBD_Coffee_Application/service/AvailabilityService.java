package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;

import java.util.List;

public interface AvailabilityService {
    public String createAvailability(Availability availability);
    public String deleteAvailability(Integer availabilityID);
    public Availability getAvailability(Integer availabilityID);
    public List<Availability> getAllAvailability();
}
