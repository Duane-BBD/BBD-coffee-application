package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ReceiveOrderDetailDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;

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
