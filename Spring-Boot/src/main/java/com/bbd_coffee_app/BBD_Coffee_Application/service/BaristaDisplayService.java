package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.BaristaDisplayDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;

import java.util.List;

public interface BaristaDisplayService {
    public List <BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue);
}
