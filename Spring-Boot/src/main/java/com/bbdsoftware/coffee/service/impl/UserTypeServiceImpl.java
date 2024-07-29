package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.model.UserType;
import com.bbdsoftware.coffee.repository.UserTypeRepository;
import com.bbdsoftware.coffee.service.UserTypeService;
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
