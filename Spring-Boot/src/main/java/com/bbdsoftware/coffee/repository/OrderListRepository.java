package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.model.OrderList;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    @Query("SELECT orderID, productID, quantity FROM OrderList ol WHERE ol.userID = :userID")
    List<OrderList> findOrdersByUserId(Integer userID);

    @Query("SELECT new com.bbdsoftware.coffee.DTO.BaristaDisplayDTO(ol.orderID, p.productName, ol.quantity) " +
            "FROM OrderList ol " +
            "JOIN Product p ON p.productID = ol.productID " +
            "JOIN AppUser a ON a.userID = ol.userID " +
            "JOIN OrderStatus os ON os.orderStatusID = ol.orderStatusID " +
            "WHERE a.officeID = :officeID AND os.orderStatusValue = :orderStatusValue")
    List<BaristaDisplayDTO> fetchBaristaDisplayDetails(@Param("officeID") Integer officeID, @Param("orderStatusValue") String orderStatusValue);
}
