package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeResponseDTO;

import java.util.List;

public interface OfficeService {
    Office createOffice(Office office);
    Office getOffice(Integer officeID);
    List<Office> getAllOffice();
    List<OfficeResponseDTO> getAllOfficeDTOs(); // New method to return OfficeDTOs
}
