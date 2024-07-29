package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.service.BaristaDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bbd-coffee/barista-display")
public class BaristaDisplayController {
    @Autowired
    BaristaDisplayService baristaDisplayService;

    @GetMapping("{officeID}/{orderStatusValue}")
    public ResponseEntity<List<BaristaDisplayDTO>> getStatusValueByOfficeID(@PathVariable Integer officeID, @PathVariable String orderStatusValue){
        try {
            List<BaristaDisplayDTO> baristaDisplay = baristaDisplayService.getOrderByStatus(officeID, orderStatusValue);
            return new ResponseEntity<>(baristaDisplay, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
