package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;
import com.bbdsoftware.coffee.model.OrderList;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
}
