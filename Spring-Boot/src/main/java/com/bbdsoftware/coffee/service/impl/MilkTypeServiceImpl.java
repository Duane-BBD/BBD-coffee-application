package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.model.MilkType;
import com.bbdsoftware.coffee.repository.MilkTypeRepository;
import com.bbdsoftware.coffee.service.MilkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilkTypeServiceImpl implements MilkTypeService {
    @Autowired
    MilkTypeRepository milkTypeRepository;

    @Override
    public MilkType getMilkType(Integer milkID) {
        Optional<MilkType> optional = milkTypeRepository.findById(milkID);
        return optional.orElseGet(() -> null);
    }

    @Override
    public List<MilkType> getAllMilkType() {
        return milkTypeRepository.findAll();
    }
}
