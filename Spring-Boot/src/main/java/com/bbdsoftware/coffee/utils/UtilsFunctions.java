package com.bbdsoftware.coffee.utils;

import com.bbdsoftware.coffee.model.*;
import com.bbdsoftware.coffee.service.AppUserService;
import com.bbdsoftware.coffee.service.MilkTypeService;
import com.bbdsoftware.coffee.service.OrderHistoryService;
import com.bbdsoftware.coffee.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Component
public class UtilsFunctions {

    @Autowired
    OrderHistoryService orderHistoryService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    MilkTypeService milkTypeService;

    @Autowired
    UserStatusService userStatusService;

    public static AppUser updatedAppuser(AppUser appUser, AppUser user){
        if(appUser.getFirstName() != null) {
            user.setFirstName(appUser.getFirstName());
        }
        if(appUser.getLastName() != null) {
            user.setLastName(appUser.getLastName());
        }
        return user;
    }

    public Boolean isLate(Integer orderID) {
        List<OrderHistory> allHistory = orderHistoryService.getAllHistory();
        OrderHistory reqHistory = new OrderHistory();
        for(OrderHistory history : allHistory) {
            if(Objects.equals(history.getOrderID(), orderID))
                reqHistory = history;
        }
        long oneHourAgoMillis = reqHistory.getOrderTime().getTime() + (60 * 60 * 1000);
        return reqHistory.getOrderTime().getTime() <= oneHourAgoMillis && oneHourAgoMillis <= Timestamp.from(Instant.now()).getTime();
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

    public Boolean isBanned(Integer userID) {
        return appUserService.getUser(userID).getUserStatusID() == 3;
    }

    public Integer getMilkByType(String milkType) {
        List<MilkType> allMilk = milkTypeService.getAllMilkType();
        for(MilkType milk : allMilk){
            if(Objects.equals(milk.getMilkTypeValue(), milkType))
                return milk.getMilkTypeID();
        }
        return null;
    }
//
//    @Scheduled(cron = "0 * 19 * * ?")
//    public void scheduleTask()
//    {
//
//    }
}
