package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.model.UserStatus;
import com.bbdsoftware.coffee.repository.UsersStatusRepository;
import com.bbdsoftware.coffee.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    UsersStatusRepository usersStatusRepository;

    public UserStatusServiceImpl(UsersStatusRepository usersStatusRepository) {
        this.usersStatusRepository = usersStatusRepository;
    }

    @Override
    public UserStatus getUserStatus(Integer userStatusID){
        Optional<UserStatus> optional = usersStatusRepository.findById(userStatusID);
        return optional.orElse(null);
    }

    @Override
    public List<UserStatus> getAllUserStatus(){
        return usersStatusRepository.findAll();
    }
}
