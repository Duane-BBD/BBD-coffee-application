package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.AvailabilityDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderHistoryDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

//    @GetMapping("{availabilityID}")
//    public Availability getAvailability(@PathVariable("availabilityID") Integer availabilityID) {
//        return availabilityService.getAvailability(availabilityID);
//    }
//
//    @GetMapping()
//    public List<Availability> getAllAvailability() {
//        return availabilityService.getAllAvailability();
//    }
//
//    @PostMapping
//    public String createAvailability(@RequestBody Availability availability) {
//        return availabilityService.createAvailability(availability);
//    }
//    @DeleteMapping("{availabilityID}")
//    public String deleteAvailability(@PathVariable("availabilityID") Integer availabilityID) {
//        return availabilityService.deleteAvailability(availabilityID);
//    }
    @GetMapping("/")
    public ResponseEntity<List<AvailabilityDTO>> getAllAvailability() {
        List<Availability> availabilities = availabilityService.getAllAvailability();
        List<AvailabilityDTO> availabilitiesDTOS = availabilities.stream()
                .map(AvailabilityDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(availabilitiesDTOS);
    }
}
