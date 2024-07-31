package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.MilkType;

import java.util.List;

public interface MilkTypeService {
    public MilkType getMilkType(Integer milkID);
    public List<MilkType> getAllMilkType();
}
