package com.example.demo.service.impl;

import com.example.demo.model.UserStatus;
import com.example.demo.repository.UsersStatusRepository;
import com.example.demo.service.UserStatusService;
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
