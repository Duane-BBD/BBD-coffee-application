package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping("{availabilityID}")
    public Availability getAvailability(@PathVariable("availabilityID") Integer availabilityID) {
        return availabilityService.getAvailability(availabilityID);
    }

    @GetMapping()
    public List<Availability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }

    @PostMapping
    public String createAvailability(@RequestBody Availability availability) {
        return availabilityService.createAvailability(availability);
    }

    @DeleteMapping("{availabilityID}")
    public String deleteAvailability(@PathVariable("availabilityID") Integer availabilityID) {
        return availabilityService.deleteAvailability(availabilityID);
    }
}
