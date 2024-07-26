package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.exception.BadRequestException;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office createOffice(Office office) throws BadRequestException{
        if (office.getOfficeName() == null || office.getOfficeName().trim().isEmpty()) {
            throw new BadRequestException("officeName cannot be empty.");
        }
        return officeRepository.save(office);
    }

    @Override
    public Office getOffice(Integer officeID) throws ResourceNotFoundException,DataAccessResourceFailureException{
        return officeRepository.findById(officeID).orElse(null);
    }

    @Override
    public List<Office> getAllOffice() throws DataAccessResourceFailureException,ResourceNotFoundException{
        return officeRepository.findAll();
    }

    @Override
    public List<OfficeResponseDTO> getAllOfficeDTOs() throws DataAccessResourceFailureException {
        List<Office> offices = getAllOffice();
        return offices.stream()
                .sorted((o1, o2) -> Integer.compare(o1.getOfficeID(), o2.getOfficeID()))
                .map(office -> {
                    OfficeResponseDTO dto = new OfficeResponseDTO();
                    dto.setOfficeID(office.getOfficeID());
                    dto.setOfficeName(office.getOfficeName());
                    return dto;
                }).collect(Collectors.toList());
    }
}
