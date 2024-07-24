package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserRegisterDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;

import java.util.List;

public interface AppUserService {

    public void createUser(AppUser appUser);
//    public String updateUser(AppUser appUser, Integer appUserID);
//    public String deleteUser(Integer appUserID);
//    public AppUser getUser(Integer appUserID);
    public List<AppUser> getAllUsers();
    public void banUser(Integer userID);

//    AppUser registerUser(UserRegisterDTO userRegisterDTO);
}