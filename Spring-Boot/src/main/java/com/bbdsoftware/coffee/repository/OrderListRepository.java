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

    @Query("SELECT ol.orderID, p.productName, ol.quantity, ol.notes, mt.milkTypeValue\n" +
            "FROM OrderList ol \n" +
            "INNER JOIN Product p ON p.productID = ol.productID\n" +
            "INNER JOIN MilkType mt ON mt.milkTypeID = ol.milkTypeID\n" +
            "INNER JOIN OrderStatus os ON os.orderStatusID = ol.orderStatusID \n" +
            "WHERE ol.office.officeID = :officeID AND os.orderStatusValue = :orderStatusValue")
    List<BaristaDisplayDTO> fetchBaristaDisplayDetails(@Param("officeID") Integer officeID, @Param("orderStatusValue") String orderStatusValue);
}
