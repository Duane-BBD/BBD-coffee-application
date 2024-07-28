package com.bbd_coffee_app.BBD_Coffee_Application.utils;

import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderStatus;
import com.bbd_coffee_app.BBD_Coffee_Application.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class UtilsFunctions {

    @Autowired
    OrderHistoryService orderHistoryService;

    public static AppUser updatedAppuser(AppUser appUser, AppUser user){
        if(appUser.getFirstName() != null) {
            user.setFirstName(appUser.getFirstName());
        }
        if(appUser.getLastName() != null) {
            user.setLastName(appUser.getLastName());
        }
        return user;
    }

    public void logHistory(OrderList order, Integer orderID) {
        OrderHistory entry = new OrderHistory();
        entry.setOrderID(orderID);
        OrderStatus data = new OrderStatus();
        data.setOrderStatusID(order.getOrderStatusID());
        entry.setOrderStatusID(data);
        entry.setOrderTime(Timestamp.from(Instant.now()));
        orderHistoryService.createHistory(entry);
    }
}
