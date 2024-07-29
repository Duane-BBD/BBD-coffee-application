package com.bbdsoftware.coffee.service.impl;
import com.bbdsoftware.coffee.DTO.UserRegisterDTO;
import com.bbdsoftware.coffee.model.AppUser;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.repository.AppUserRepository;

import com.bbdsoftware.coffee.service.AppUserService;
import com.bbdsoftware.coffee.service.OfficeService;
import com.bbdsoftware.coffee.service.UserRegisterService;
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
