package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.repository.OrderListRepository;
import com.bbdsoftware.coffee.service.BaristaDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaristaDisplayServiceImpl implements BaristaDisplayService {

    @Autowired
    private OrderListRepository orderListRepository;

    @Override
    public List<BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue) {
        return orderListRepository.fetchBaristaDisplayDetails(officeID, orderStatusValue);
    }
}
