package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.UserType;

import java.util.List;

public interface UserTypeService {
    public UserType getType(Integer userTypeID);
    public List<UserType> getAllType();
}
