package com.bbd_coffee_app.BBD_Coffee_Application.service;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;

import java.util.List;

public interface OfficeService {
    Office createOffice(Office office);
    Office getOffice(Integer officeID);
//    List<Office> getAllOffice(Integer userTypeID);
    public List<Office> getAllOffice();

}