package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOfficeDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bbd-coffee/user-office")
public class UserOfficeController {
    @Autowired
    UserOfficeService userOfficeService;

    @GetMapping("/details")
    public List<UserOfficeDTO> getAllUsers() {
        return userOfficeService.getAllUsers();
    }
}
