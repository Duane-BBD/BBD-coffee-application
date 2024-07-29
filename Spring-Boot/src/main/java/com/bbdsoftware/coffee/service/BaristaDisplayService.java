package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.DTO.BaristaDisplayDTO;

import java.util.List;

public interface BaristaDisplayService {
    public List <BaristaDisplayDTO> getOrderByStatus(Integer officeID, String orderStatusValue);
}
