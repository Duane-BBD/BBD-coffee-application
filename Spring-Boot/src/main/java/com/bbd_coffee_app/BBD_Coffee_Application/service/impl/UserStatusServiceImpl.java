package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.UserStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.UsersStatusRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    UsersStatusRepository usersStatusRepository;

    public UserStatusServiceImpl(UsersStatusRepository usersStatusRepository) {
        this.usersStatusRepository = usersStatusRepository;
    }

    @Override
    public UserStatus getUserStatus(Integer userStatusID){
        return usersStatusRepository.findById(userStatusID).get();
    }

    @Override
    public List<UserStatus> getAllUserStatus(){
        return usersStatusRepository.findAll();
    }
}
