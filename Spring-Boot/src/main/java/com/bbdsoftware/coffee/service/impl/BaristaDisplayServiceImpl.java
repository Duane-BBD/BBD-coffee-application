package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.model.OrderList;
import com.bbdsoftware.coffee.repository.OrderListRepository;
import com.bbdsoftware.coffee.service.BaristaDisplayService;
import com.bbdsoftware.coffee.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaristaDisplayServiceImpl implements BaristaDisplayService {

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private OrderListService orderListService;

    @Override
    public List<BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue) {
//        List<BaristaDisplayDTO> ordersForBarista = new ArrayList<>();
//        List<OrderListDTO> orders = orderListService.getOrderDetailsByOfficeID(officeID);
//        for(OrderListDTO order : orders) {
//
//        }
        return orderListRepository.fetchBaristaDisplayDetails(officeID, orderStatusValue);
    }
}
