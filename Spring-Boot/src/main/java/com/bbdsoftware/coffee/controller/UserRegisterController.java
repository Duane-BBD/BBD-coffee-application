package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.DTO.UserRegisterDTO;
import com.bbdsoftware.coffee.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bbd-coffee/users")
public class UserRegisterController {
    @Autowired
    UserRegisterService userRegisterService;

    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            userRegisterService.registerUser(userRegisterDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
