package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.exception.BadRequestException;
import com.bbdsoftware.coffee.exception.ResourceNotFoundException;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.DTO.OfficeResponseDTO;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

public interface OfficeService {
    Office createOffice(Office office) throws BadRequestException;
    Office getOffice(Integer officeID) throws ResourceNotFoundException,DataAccessResourceFailureException;
    List<Office> getAllOffice() throws DataAccessResourceFailureException,ResourceNotFoundException;
    List<OfficeResponseDTO> getAllOfficeDTOs() throws DataAccessResourceFailureException;
}
