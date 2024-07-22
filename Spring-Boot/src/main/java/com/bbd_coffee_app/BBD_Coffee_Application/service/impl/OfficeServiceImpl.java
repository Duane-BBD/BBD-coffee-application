package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public String createOffice(Office office) {
        officeRepository.save(office);
        return "Create Success!";
    }

    @Override
    public String deleteOffice(Integer officeID) {
        officeRepository.deleteById(officeID);
        return "Delete Success!";
    }

    @Override
    public Office getOffice(Integer officeID) {
        return officeRepository.findById(officeID).get();
    }

    @Override
    public List<Office> getAllOffice() {
        return officeRepository.findAll();
    }
}
