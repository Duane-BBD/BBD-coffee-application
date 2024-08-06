package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.model.OrderHistory;
import com.bbdsoftware.coffee.model.OrderList;
import com.bbdsoftware.coffee.repository.OrderListRepository;
import com.bbdsoftware.coffee.service.BaristaDisplayService;
import com.bbdsoftware.coffee.service.OrderHistoryService;
import com.bbdsoftware.coffee.service.OrderListService;
import com.bbdsoftware.coffee.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BaristaDisplayServiceImpl implements BaristaDisplayService {

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Override
    public List<BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue) {
        List<BaristaDisplayDTO> ordersForBarista = new ArrayList<>();
        List<OrderListDTO> orders = orderListService.getOrderDetailsByOfficeID(officeID);
        for(OrderListDTO order : orders) {
            BaristaDisplayDTO baristaOrder = new BaristaDisplayDTO();
            if (Objects.equals(order.getStatus(), orderStatusValue)) {
                baristaOrder.setOrderID(order.getOrderID());
                baristaOrder.setQuantity(order.getQuantity());
                baristaOrder.setNotes(order.getNote());
                baristaOrder.setMilkTypeValue(order.getMilkTypeValue());
                baristaOrder.setProductName(order.getProductName());
                List<OrderHistory> history = orderHistoryService.getAllHistory();
                for (OrderHistory hist : history) {
                    if (Objects.equals(orderStatusService.getOrderStatus(hist.getOrderStatusID().getOrderStatusID()).getOrderStatusValue(), orderStatusValue)) {
                        baristaOrder.setOrderTime(hist.getOrderTime());
                    }
                }
                ordersForBarista.add(baristaOrder);
            }
        }
        return ordersForBarista;
    }
}
