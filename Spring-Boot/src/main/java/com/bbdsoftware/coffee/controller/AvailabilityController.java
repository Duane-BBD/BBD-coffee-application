package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.AvailabilityDTO;
import com.bbdsoftware.coffee.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bbd-coffee/availability")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

//    @GetMapping("{officeID}")
//    public List<AvailabilityDTO> getAvailability(@PathVariable("officeID") Integer officeID) {
//        return availabilityService.getAvailabilityByID(officeID);
//    }
//
//    @GetMapping()
//    public List<Availability> getAllAvailability() {
//        return availabilityService.getAllAvailability();
//    }

    @PostMapping("/add-products")
    public ResponseEntity<String> createAvailability(@RequestBody AvailabilityDTO availabilityDTO) {
//        return ResponseEntity.ok("User created");
        try {
            availabilityService.createAvailability(availabilityDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-all-available")
    public ResponseEntity<List<AvailabilityDTO>> getAllAvailability() {
        try {
            List<AvailabilityDTO> availabilities = availabilityService.getAllAvailability();
            return new ResponseEntity<>(availabilityService.getAllAvailability(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @DeleteMapping("{availabilityID}")
//    public String deleteAvailability(@PathVariable("availabilityID") Integer availabilityID) {
//        return availabilityService.deleteAvailability(availabilityID);
//    }
}
