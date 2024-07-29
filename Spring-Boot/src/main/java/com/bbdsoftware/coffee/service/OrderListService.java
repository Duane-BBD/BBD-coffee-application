package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.DTO.ReceiveOrderDetailDTO;
import com.bbdsoftware.coffee.model.OrderList;

import java.util.List;

public interface OrderListService {
    OrderListDTO getOrderDetails(Integer orderID);
    List<OrderListDTO> getOrderDetailsByOfficeID(Integer officeID); // New method
    String updateOrderStatus(Integer orderID);
    String createOrder(List<ReceiveOrderDetailDTO> orderDetailDTO);
    String cancelOrder(Integer orderID);
    List<OrderListDTO> pastOrders(Integer userID);
    String updateOrder(OrderList orderList, Integer orderID);
    String deleteOrder(Integer orderID);
    OrderList getOrder(Integer orderID);
    List<OrderList> getAllOrders();
}
