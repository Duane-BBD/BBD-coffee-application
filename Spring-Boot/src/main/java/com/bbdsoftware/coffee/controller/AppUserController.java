package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.model.AppUser;
import com.bbdsoftware.coffee.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbd-coffee/app-user")
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping("/get-user/{userID}")
    public ResponseEntity<AppUser> getUser(@PathVariable("userID") Integer userID) {
        try {
            return new ResponseEntity<>(appUserService.getUser(userID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
