package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOfficeDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AppUserRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.UserOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserOfficeServiceImpl implements UserOfficeService {
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<UserOfficeDTO> getAllUsers() {
        return appUserRepository.fetchUserDetails();
    }
}
