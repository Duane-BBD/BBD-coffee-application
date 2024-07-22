package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.UserType;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.UserTypeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserType getType(Integer userTypeID) {
        return userTypeRepository.findById(userTypeID).get();
    }

    @Override
    public List<UserType> getAllType() {
        return userTypeRepository.findAll();
    }
}
