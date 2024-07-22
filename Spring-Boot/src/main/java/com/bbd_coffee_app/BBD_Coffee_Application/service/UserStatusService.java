package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.example.demo.model.UserStatus;

import java.util.List;

public interface UserStatusService {
    UserStatus getUserStatus(Integer userStatusID);
    List<UserStatus> getAllUserStatus();
}
