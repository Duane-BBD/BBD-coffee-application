package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office getOffice(Integer officeID) {
        return officeRepository.findById(officeID).orElse(null);
    }

    @Override
    public List<Office> getAllOffice() {
        return officeRepository.findAll();
    }

    @Override
    public List<OfficeDTO> getAllOfficeDTOs() {
        List<Office> offices = getAllOffice();
        return offices.stream()
                .sorted((o1, o2) -> Integer.compare(o1.getOfficeID(), o2.getOfficeID()))
                .map(office -> {
                    OfficeDTO dto = new OfficeDTO();
                    dto.setOfficeID(office.getOfficeID());
                    dto.setOfficeName(office.getOfficeName());
                    return dto;
                }).collect(Collectors.toList());
    }
}
