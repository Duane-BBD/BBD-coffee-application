package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserRegisterDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AppUserRepository;

import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserService appUserService;

    @Autowired
    OfficeService officeService;

    public UserRegisterServiceImpl(AppUserRepository appUserRepository, AppUserService appUserService, OfficeService officeService) {
        this.appUserRepository = appUserRepository;
        this.appUserService = appUserService;
        this.officeService = officeService;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {
        //user.setUserID(userRegisterDTO.getUserID());
//        user.setFirstName(userRegisterDTO.getFirstName());
//        user.setLastName(userRegisterDTO.getLastName());
        List<Office> allOffice = officeService.getAllOffice();
        Integer ID = 0;
        for (Office office: allOffice) {
            if(Objects.equals(office.getOfficeName(), userRegisterDTO.getOfficeName())) {
                ID = office.getOfficeID();
            }
        }
        AppUser user = new AppUser(userRegisterDTO.getUserID(), userRegisterDTO.getFirstName(), userRegisterDTO.getLastName(), ID, 1,1);
        appUserService.createUser(user);
    }
}
