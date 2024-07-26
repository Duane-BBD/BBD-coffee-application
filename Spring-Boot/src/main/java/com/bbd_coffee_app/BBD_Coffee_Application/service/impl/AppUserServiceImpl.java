package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserRegisterDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.BadRequestException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ConflictException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AppUserRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void createUser(AppUser appUser) throws BadRequestException, ConflictException{
        appUserRepository.save(appUser);
    }
//
//    @Override
//    public String updateUser(AppUser appUser, Integer appUserID) {
//        Optional<AppUser> optional = appUserRepository.findById(appUserID);
//
//        if(optional.isPresent()) {
//            AppUser user = optional.get();
//            appUserRepository.save(UtilsFunctions.updatedAppuser(appUser, user));
//        }
//        else {
//            throw new RuntimeException("User not found!");
//        }
//
//        return "Update Success!";
//    }
//
//    @Override
//    public String deleteUser(Integer appUserID) {
//        appUserRepository.deleteById(appUserID);
//        return "Delete Success!";
//    }
//
//    @Override
//    public AppUser getUser(Integer appUserID) {
//        return appUserRepository.findById(appUserID).get();
//    }

    @Override
    public List<AppUser> getAllUsers() throws DataAccessResourceFailureException {
        try {
            return appUserRepository.findAll();
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Unable to access data", e);
        }
    }

    @Override
    public void banUser(Integer userID) throws ResourceNotFoundException {
        Optional<AppUser> optional = appUserRepository.findById(userID);
        if(optional.isPresent()) {
            AppUser user = optional.get();
            user.setUserStatusID(3);
            user.setBannedUntil(Timestamp.from(Instant.now().plusSeconds(24 * 60 * 60)));
            appUserRepository.save(user);
        }else {
            throw new ResourceNotFoundException("User not found with id: " + userID);
        }
    }

//    public void userRegister(AppUserRepository appUserRepository) {
//        this.appUserRepository = appUserRepository;
//    }


//    public AppUser registerUser(UserRegisterDTO userRegisterDTO) {
//        AppUser user = new AppUser();
//        user.setUserID(userRegisterDTO.getUserID());
//        user.setFirstName(userRegisterDTO.getFirstName());
//        user.setLastName(userRegisterDTO.getLastName());
//        user.setOffice(userRegisterDTO.getOfficeName());
//
//        return appUserRepository.save(user);
//    }
}
