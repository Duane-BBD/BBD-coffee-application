package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.model.MilkType;
import com.bbdsoftware.coffee.service.MilkTypeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("bbd-coffee")
public class MilkController {
    @Autowired
    MilkTypeService milkTypeService;

    @GetMapping(value = { "/get-milk-types", "/get-milk-types/{milkTypeID}" })
    public ResponseEntity<List<MilkType>> getMilkTypes(@PathVariable(required = false) Integer milkTypeID) {
        try {
            return (milkTypeID != null)
                    ? new ResponseEntity<>(List.of(milkTypeService.getMilkType(milkTypeID)), HttpStatus.CREATED)
                    : new ResponseEntity<>(milkTypeService.getAllMilkType(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
