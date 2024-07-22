package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;

import java.util.List;

public interface OfficeService {
    public String createOffice(Office office);
    public String deleteOffice(Integer officeID);
    public Office getOffice(Integer officeID);
    public List<Office> getAllOffice();
}
