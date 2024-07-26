package com.bbd_coffee_app.BBD_Coffee_Application.service;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ReceiveOrderDetailDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;

import java.util.List;

public interface OrderListService {
    public OrderListDTO getOrderDetails(Integer orderID);
    public String updateOrderStatus(Integer orderID);
    public void createOrder(List<ReceiveOrderDetailDTO> orderDetailDTO);
    public String updateOrder(OrderList orderList, Integer orderID);
    public String deleteOrder(Integer orderID);
    public OrderList getOrder(Integer orderID);
    public List<OrderList> getAllOrders();
}
