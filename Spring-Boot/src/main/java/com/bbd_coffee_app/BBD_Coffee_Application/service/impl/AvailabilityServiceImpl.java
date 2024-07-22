package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AvailabilityRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    @Autowired
    AvailabilityRepository availabilityRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public String createAvailability(Availability availability) {
        availabilityRepository.save(availability);
        return "Create Success!";
    }

    @Override
    public String deleteAvailability(Integer availabilityID) {
        availabilityRepository.deleteById(availabilityID);
        return "Delete Success!";
    }

    @Override
    public Availability getAvailability(Integer availabilityID) {
        return availabilityRepository.findById(availabilityID).get();
    }

    @Override
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }
}
