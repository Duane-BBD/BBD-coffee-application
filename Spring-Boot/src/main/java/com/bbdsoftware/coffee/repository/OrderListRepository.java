package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.model.OrderList;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    @Query("SELECT new com.bbdsoftware.coffee.DTO.BaristaDisplayDTO(ol.orderID, p.productName, ol.quantity, ol.notes, mt.milkTypeValue) " +
            "FROM OrderList ol " +
            "INNER JOIN Product p ON p.productID = ol.productID " +
            "INNER JOIN MilkType mt ON mt.milkTypeID = ol.milkTypeID " +
            "INNER JOIN OrderStatus os ON os.orderStatusID = ol.orderStatusID " +
            "WHERE ol.office.officeID = :officeID AND os.orderStatusValue = :orderStatusValue")
    List<BaristaDisplayDTO> fetchBaristaDisplayDetails(@Param("officeID") Integer officeID, @Param("orderStatusValue") String orderStatusValue);
}
