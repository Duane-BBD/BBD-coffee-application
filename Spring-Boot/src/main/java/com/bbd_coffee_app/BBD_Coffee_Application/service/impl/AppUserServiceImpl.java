package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AppUserRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String createUser(AppUser appUser) {
        appUserRepository.save(appUser);
        return "Create Success!";
    }

    @Override
    public String updateUser(AppUser appUser, Integer appUserID) {
        Optional<AppUser> optional = appUserRepository.findById(appUserID);

        if(optional.isPresent()) {
            AppUser user = optional.get();

            appUserRepository.save(UtilsFunctions.updatedAppuser(appUser, user));
        }
        else {
            throw new RuntimeException("User not found!");
        }

//        appUserRepository.save(appUser);
        return "Update Success!";
    }

    @Override
    public String deleteUser(Integer appUserID) {
        appUserRepository.deleteById(appUserID);
        return "Delete Success!";
    }

    @Override
    public AppUser getUser(Integer appUserID) {
        return appUserRepository.findById(appUserID).get();
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
