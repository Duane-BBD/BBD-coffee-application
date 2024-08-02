package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.OfficeCreateDTO;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.service.OfficeService;
import com.bbdsoftware.coffee.DTO.OfficeResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bbd-coffee/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("add-location")
    public ResponseEntity<Void> createOffice(@RequestBody OfficeCreateDTO officeCreateDTO) {
        Office office = new Office();
        office.setOfficeName(officeCreateDTO.getOfficeName());
        officeService.createOffice(office);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("list-all-office")
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
