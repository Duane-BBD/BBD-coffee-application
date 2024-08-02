package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.exception.BadRequestException;
import com.bbdsoftware.coffee.exception.ConflictException;
import com.bbdsoftware.coffee.exception.ResourceNotFoundException;
import com.bbdsoftware.coffee.model.AppUser;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

public interface AppUserService {

    void createUser(AppUser appUser) throws BadRequestException, ConflictException;
//    String updateUser(AppUser appUser, Integer appUserID);
//    String deleteUser(Integer appUserID);
    AppUser getUser(Integer appUserID);
    List<AppUser> getAllUsers() throws BadRequestException,DataAccessResourceFailureException;
    void banUser(Integer userID) throws ResourceNotFoundException;
//    AppUser registerUser(UserRegisterDTO userRegisterDTO);
}