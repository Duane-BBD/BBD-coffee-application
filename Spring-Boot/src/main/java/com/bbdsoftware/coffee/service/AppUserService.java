package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.exception.BadRequestException;
import com.bbdsoftware.coffee.exception.ConflictException;
import com.bbdsoftware.coffee.exception.ResourceNotFoundException;
import com.bbdsoftware.coffee.model.AppUser;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

public interface AppUserService {

    public void createUser(AppUser appUser) throws BadRequestException, ConflictException;
//    public String updateUser(AppUser appUser, Integer appUserID);
//    public String deleteUser(Integer appUserID);
    public AppUser getUser(Integer appUserID);
    public List<AppUser> getAllUsers() throws BadRequestException,DataAccessResourceFailureException;
    public void banUser(Integer userID) throws ResourceNotFoundException;
//    AppUser registerUser(UserRegisterDTO userRegisterDTO);
}