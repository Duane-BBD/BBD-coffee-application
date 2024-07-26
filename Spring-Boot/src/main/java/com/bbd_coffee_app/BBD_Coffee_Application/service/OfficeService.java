package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.exception.BadRequestException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeResponseDTO;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

public interface OfficeService {
    Office createOffice(Office office) throws BadRequestException;
    Office getOffice(Integer officeID) throws ResourceNotFoundException,DataAccessResourceFailureException;
    List<Office> getAllOffice() throws DataAccessResourceFailureException,ResourceNotFoundException;
    List<OfficeResponseDTO> getAllOfficeDTOs() throws DataAccessResourceFailureException;
}
