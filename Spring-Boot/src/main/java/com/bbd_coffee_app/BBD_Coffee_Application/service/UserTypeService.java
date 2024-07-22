package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.UserType;

import java.util.List;

public interface UserTypeService {
    public UserType getType(Integer userTypeID);
    public List<UserType> getAllType();
}
