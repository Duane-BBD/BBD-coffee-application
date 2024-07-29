package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.DTO.OrderHistoryDTO;
import com.bbdsoftware.coffee.model.OrderHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderHistoryService {
    public void createHistory(OrderHistory orderHistory);
//     List<OrderHistory> getHistory(Integer orderHistoryID);
     List<OrderHistory> getAllHistory();
     List<OrderHistoryDTO> getOrderHistory(Integer orderID);
}
