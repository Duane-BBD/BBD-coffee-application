package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.exception.BadRequestException;
import com.bbdsoftware.coffee.exception.ResourceNotFoundException;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.repository.OfficeRepository;
import com.bbdsoftware.coffee.service.OfficeService;
import com.bbdsoftware.coffee.DTO.OfficeResponseDTO;
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
    public Office createOffice(Office office) throws BadRequestException {
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
