package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.UserStatus;

import java.util.List;

public interface UserStatusService {
    UserStatus getUserStatus(Integer userStatusID);
    List<UserStatus> getAllUserStatus();
}
