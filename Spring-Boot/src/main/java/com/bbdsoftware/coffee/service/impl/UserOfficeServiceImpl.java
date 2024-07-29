package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.UserOfficeDTO;
import com.bbdsoftware.coffee.repository.AppUserRepository;
import com.bbdsoftware.coffee.service.UserOfficeService;
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
