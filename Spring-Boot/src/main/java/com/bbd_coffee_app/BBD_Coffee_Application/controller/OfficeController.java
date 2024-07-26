package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeCreateDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeResponseDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.BadRequestException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ConflictException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping
    public ResponseEntity<Void> createOffice(@RequestBody OfficeCreateDTO officeCreateDTO) {
        if (officeCreateDTO.getOfficeName() == null || officeCreateDTO.getOfficeName().trim().isEmpty()) {
            throw new BadRequestException("officeName cannot be empty.");
        }
        Office office = new Office();
        office.setOfficeName(officeCreateDTO.getOfficeName());
        officeService.createOffice(office);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OfficeResponseDTO>> getAllOffice() {
        List<OfficeResponseDTO> officeDTOs = officeService.getAllOffice().stream()
                .map(office -> {
                    OfficeResponseDTO dto = new OfficeResponseDTO();
                    dto.setOfficeID(office.getOfficeID());
                    dto.setOfficeName(office.getOfficeName());
                    return dto;
                })
                .sorted(Comparator.comparing(OfficeResponseDTO::getOfficeID)) // Sort by officeID
                .collect(Collectors.toList());
        return new ResponseEntity<>(officeDTOs, HttpStatus.OK);
    }


}
