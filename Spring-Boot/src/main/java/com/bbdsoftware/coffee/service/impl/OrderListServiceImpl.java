package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.OrderListDTO;
import com.bbdsoftware.coffee.DTO.ReceiveOrderDetailDTO;
import com.bbdsoftware.coffee.exception.ResourceNotFoundException;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.model.OrderList;
import com.bbdsoftware.coffee.service.*;
import com.bbdsoftware.coffee.repository.AppUserRepository;
import com.bbdsoftware.coffee.repository.OrderListRepository;
import com.bbdsoftware.coffee.repository.OrderStatusRepository;
import com.bbdsoftware.coffee.repository.ProductRepository;
import com.bbdsoftware.coffee.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    ProductService productService;

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    MilkTypeService milkTypeService;

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
    public List<OrderListDTO> getOrderDetailsByOfficeID(Integer officeID) {
        List<OrderList> orders = orderListRepository.findAll();
        List<OrderListDTO> orderDTOs = orders.stream()
                .filter(order -> order.getOffice().getOfficeID().equals(officeID))
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        if (orderDTOs.isEmpty()) {
            throw new ResourceNotFoundException("Orders in OfficeID " + officeID + " do not exist!");
        }

        return orderDTOs;
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
        item.setNote(orderListRepository.findById(order.getOrderID()).get().getNotes());
        item.setMilkTypeValue(milkTypeService.getMilkType(orderListRepository.findById(order.getOrderID()).get().getMilkTypeID()).getMilkTypeValue());
        return item;
    }

    @Override
    public String createOrder(List<ReceiveOrderDetailDTO> allOrderDetailDTO) {
        List<Integer> orderIDs = new ArrayList<>();
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
            newOrder.setMilkTypeID(utils.getMilkByType(orderDetailDTO.getMilkTypeValue()));
            newOrder.setNotes(orderDetailDTO.getNote());
            orderListRepository.save(newOrder);
            orderIDs.add(orderListRepository.findAll().size());
            utils.logHistory(newOrder, orderListRepository.findAll().size());
        }
        return "Order placed at " + orderIDs + "!";
    }

    @Override
    public String cancelOrder(Integer orderID) {
        Optional<OrderList> order = orderListRepository.findById(orderID);
        if(order.isEmpty()) {
            return "Order with orderID " + orderID + " not found!";
        }
        if(order.get().getOrderStatusID() == 1) {
            order.get().setOrderStatusID(5);
            utils.logHistory(order.get(), orderID);
            return "Order cancelled!";
        }
        return "Order cannot be cancelled since the order is not in pending state!";
    }

    @Override
    public List<OrderListDTO> pastOrders(Integer userID) {
        List<OrderList> allOrders = orderListRepository.findAll();
        List<OrderListDTO> userPastOrder = new ArrayList<>();
        for(OrderList order : allOrders) {
            if(Objects.equals(order.getUserID(), userID)) {
                OrderListDTO userOrder = new OrderListDTO();
                if(order.getOrderStatusID() == 4 || order.getOrderStatusID() == 5) {
                    userOrder.setOrderID(order.getOrderID());
                    userOrder.setQuantity(order.getQuantity());
                    userOrder.setUserName(appUserService.getUser(userID).getFirstName()+" "+appUserService.getUser(userID).getLastName());
                    userOrder.setProductName(productService.getProduct(order.getProductID()).getProductName());
                    userOrder.setStatus(orderStatusService.getOrderStatus(order.getOrderStatusID()).getOrderStatusValue());
                    userOrder.setNote(order.getNotes());
                    userOrder.setMilkTypeValue(milkTypeService.getMilkType(order.getMilkTypeID()).getMilkTypeValue());
                    userPastOrder.add(userOrder);
                }
            }
        }

        return userPastOrder;
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
