package com.example.demo.service;

import com.example.demo.model.UserStatus;

import java.util.List;

public interface UserStatusService {
    UserStatus getUserStatus(Integer userStatusID);
    List<UserStatus> getAllUserStatus();
}
