package com.bbd_coffee_app.BBD_Coffee_Application.controller;

import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import com.bbd_coffee_app.BBD_Coffee_Application.model.UserType;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {
    @Autowired
    AppUserService appUserService;
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

//    @GetMapping("{userID}")
//    public AppUser getUserDetails(@PathVariable("userID") Integer userID) {
//        return appUserService.getUser(userID);
//    }
//
//    @GetMapping()
//    public List<AppUser> getAllUserDetails() {
//        return appUserService.getAllUsers();
//    }
//
//    @PostMapping
//    public String createUser(@RequestBody AppUser appUser) {
//        return appUserService.createUser(appUser);
//    }
//
//    @PutMapping("{userID}")
//    public String updateUser(@RequestBody AppUser appUser, @PathVariable("userID") Integer userID) {
//        return appUserService.updateUser(appUser, userID);
//    }
//
//    @DeleteMapping("{userID}")
//    public String deleteAppUserDetails(@PathVariable("userID") Integer userID) {
//        return appUserService.deleteUser(userID);
//    }

    @Autowired
    UserTypeService userTypeService;

    @GetMapping("/type/{userTypeID}")
    public ResponseEntity<UserType> getTypeDetails(@PathVariable("userTypeID") Integer userTypeID) {
        try {
            return new ResponseEntity<>(userTypeService.getType(userTypeID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/type")
    public ResponseEntity<List<UserType>> getAllTypeDetails() {
        userTypeService.getAllType();
        try {
            return new ResponseEntity<>(userTypeService.getAllType(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
