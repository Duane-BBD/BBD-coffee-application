package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.OrderListDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.ReceiveOrderDetailDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.exception.ResourceNotFoundException;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.*;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AppUserService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OfficeService;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderListService;
import com.bbd_coffee_app.BBD_Coffee_Application.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    OrderListRepository orderListRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    AppUserService appUserService;

    @Autowired
    OfficeService officeService;

    @Autowired
    UtilsFunctions utils;

    public OrderListServiceImpl(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public OrderListDTO getOrderDetails(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);

        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("OrderID " + orderID + " does not exist!");
        }

        OrderList order = optional.get();
        return convertToDTO(order);
    }

    @Override
    public List<OrderListDTO> getOrderDetails(Integer orderID, Integer officeID) {
        List<OrderList> orders = orderListRepository.findAll();
        Optional<OrderList> optional = orders.stream()
                .filter(order -> order.getOrderID().equals(orderID) && order.getOffice().getOfficeID().equals(officeID))
                .findFirst();

        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("OrderID " + orderID + " in OfficeID " + officeID + " does not exist!");
        }

        OrderList order = optional.get();
        return List.of(convertToDTO(order));
    }


    @Override
    public String updateOrderStatus(Integer orderID) {
        Optional<OrderList> optional = orderListRepository.findById(orderID);
        if(optional.isEmpty()){
            throw new ResourceNotFoundException("OrderID " + orderID + " does not exist!");
        }

        OrderList order = optional.get();
        return switch (order.getOrderStatusID()) {
            case 1, 2, 3 -> {
                if (orderID == 3 && utils.isLate(orderID)) {
                    order.setOrderStatusID(5);
                    utils.logHistory(order, orderID);
                    appUserService.banUser(order.getUserID());
                    orderListRepository.save(order);
                    yield "OrderID " + orderID + " was cancelled due to being late to receive the order!";
                }
                order.setOrderStatusID(order.getOrderStatusID() + 1);
                utils.logHistory(order, orderID);
                orderListRepository.save(order);
                yield "Updated!";
            }
            case 4 -> "Order " + orderID + " is complete!";
            default -> "Order " + orderID + " was cancelled!";
        };
    }

    private OrderListDTO convertToDTO(OrderList order) {
        OrderListDTO item = new OrderListDTO();
        item.setOrderID(order.getOrderID());
        item.setUserName(appUserRepository.findById(order.getUserID()).get().getFirstName() + " " + appUserRepository.findById(order.getUserID()).get().getLastName());
        item.setProductName(productRepository.findById(order.getProductID()).get().getProductName());
        item.setQuantity(order.getQuantity());
        item.setStatus(orderStatusRepository.findById(order.getOrderStatusID()).get().getOrderStatusValue());
        item.setOfficeName(order.getOffice().getOfficeName()); // Assuming Office entity has getOfficeName()
        return item;
    }

    @Override
    public String createOrder(List<ReceiveOrderDetailDTO> allOrderDetailDTO) {
        for (ReceiveOrderDetailDTO orderDetailDTO: allOrderDetailDTO) {
            if (utils.isBanned(orderDetailDTO.getUserID())) {
                return "User is banned!";
            }
            OrderList newOrder = new OrderList();
            newOrder.setQuantity(orderDetailDTO.getQuantity());
            newOrder.setUserID(orderDetailDTO.getUserID());
            newOrder.setProductID(productRepository.findByProductName(orderDetailDTO.getProductName()));
            newOrder.setOrderStatusID(1);
            Office newOffice = new Office(orderDetailDTO.getOfficeID(), officeService.getOffice(orderDetailDTO.getOfficeID()).getOfficeName());
            newOrder.setOffice(newOffice);
            orderListRepository.save(newOrder);
            utils.logHistory(newOrder, orderListRepository.findAll().size());
        }
        return "Order placed!";
    }

    @Override
    public String cancelOrder(Integer orderID) {
        Optional<OrderList> order = orderListRepository.findById(orderID);
        if(order.isEmpty()) {
            return "Order with orderID " + orderID + "not found!";
        }
        if(utils.isPending(order.get().getOrderStatusID())) {
            order.get().setOrderStatusID(5);
            utils.logHistory(order.get(), orderID);
            return "Order cancelled!";
        }
        return "Order cannot be cancelled since the order is not in pending state!";
    }

    @Override
    public String updateOrder(OrderList orderList, Integer orderID) {
        return "Update Success!";
    }

    @Override
    public String deleteOrder(Integer orderID) {
        orderListRepository.deleteById(orderID);
        return "Delete Success!";
    }

    @Override
    public OrderList getOrder(Integer orderID) {
        return orderListRepository.findById(orderID).get();
    }

    @Override
    public List<OrderList> getAllOrders() {
        return orderListRepository.findAll();
    }
}
