package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.BaristaDisplayDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderHistory;
import com.bbd_coffee_app.BBD_Coffee_Application.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    @Query("SELECT orderID, productID, quantity FROM OrderList ol WHERE ol.userID = :userID")
    List<OrderList> findOrdersByUserId(Integer userID);

//    @Query("SELECT new com.bbd_coffee_app.BBD_Coffee_Application.DTO.BaristaDisplayDTO(ol.orderID, p.productName, ol.quantity) " +
//            "FROM orderList ol " +
//            "INNER JOIN product p ON p.productID = ol.productID " +
//            "INNER JOIN appUser a ON a.userID = ol.userID " +
//            "INNER JOIN orderStatus os ON os.orderStatusID = ol.orderStatusID " +
//            "WHERE a.officeID = :officeID AND os.orderStatusValue = :orderStatusValue)")
//    List<BaristaDisplayDTO> fetchBaristaDisplayDetails(Integer officeID, String orderStatusValue);
}
