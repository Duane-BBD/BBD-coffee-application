package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.BaristaDisplayDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OrderListRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.BaristaDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaristaDisplayImpl implements BaristaDisplayService {

    @Autowired
    OrderListRepository orderListRepository;

    @Override
    public List<BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue){
//     return orderListRepository.fetchBaristaDisplayDetails(officeID, orderStatusValue);

        return List.of();
    }
}
