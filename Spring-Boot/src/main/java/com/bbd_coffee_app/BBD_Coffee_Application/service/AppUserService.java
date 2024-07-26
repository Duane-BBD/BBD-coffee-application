package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserRegisterDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.BadRequestException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ConflictException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

public interface AppUserService {

    public void createUser(AppUser appUser) throws BadRequestException, ConflictException;
//    public String updateUser(AppUser appUser, Integer appUserID);
//    public String deleteUser(Integer appUserID);
//    public AppUser getUser(Integer appUserID);
    public List<AppUser> getAllUsers() throws BadRequestException,DataAccessResourceFailureException;
    public void banUser(Integer userID) throws ResourceNotFoundException;
//    AppUser registerUser(UserRegisterDTO userRegisterDTO);
}