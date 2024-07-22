package com.bbd_coffee_app.BBD_Coffee_Application.utils;

import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;

public class UtilsFunctions {
    public static AppUser updatedAppuser(AppUser appUser, AppUser user){
        if(appUser.getFirstName() != null) {
            user.setFirstName(appUser.getFirstName());
        }
        if(appUser.getLastName() != null) {
            user.setLastName(appUser.getLastName());
        }
        return user;
    }
}
