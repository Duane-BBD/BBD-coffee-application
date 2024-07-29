package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.DTO.AvailabilityDTO;
import com.bbdsoftware.coffee.model.Availability;
import com.bbdsoftware.coffee.model.Office;
import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.repository.AvailabilityRepository;
import com.bbdsoftware.coffee.repository.OfficeRepository;
import com.bbdsoftware.coffee.repository.ProductRepository;
import com.bbdsoftware.coffee.service.AvailabilityService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    @Autowired
    AvailabilityRepository availabilityRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OfficeRepository officeRepository;

//    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository) {
//        this.availabilityRepository = availabilityRepository;
//    }
//
//    @Override
//    public String createAvailability(Availability availability) {
//        availabilityRepository.save(availability);
//        return "Create Success!";
//    }
//
//    @Override
//    public String deleteAvailability(Integer availabilityID) {
//        availabilityRepository.deleteById(availabilityID);
//        return "Delete Success!";
//    }
//
//    @Override
//    public Availability getAvailability(Integer availabilityID) {
//        return availabilityRepository.findById(availabilityID).get();
//    }

    @Override
    public List<AvailabilityDTO> getAllAvailability() {
        List<Availability> getAvailability=availabilityRepository.findAll();
        return  getAvailability.stream()
                .map(AvailabilityDTO::new)
                .toList();
    }
    @Override
    public void createAvailability(AvailabilityDTO availabilityDTO) {
        List<Product> allProducts = productRepository.findAll();
        List<Office> allOffices = officeRepository.findAll();
        Availability newAvail = new Availability();
        for(Product prod : allProducts) {
            if (Objects.equals(prod.getProductName(), availabilityDTO.getProductName()))
                newAvail.setProductID(prod);
        }
        for(Office off : allOffices) {
            if (Objects.equals(off.getOfficeName(), availabilityDTO.getOfficeName()))
                newAvail.setOfficeID(off);
        }
        availabilityRepository.save(newAvail);
    }
//    @Override
//    public List<AvailabilityDTO> getAvailabilityByID(Integer officeID){
//        return availabilityRepository.findByOrderId(officeID).stream()
//                .map(officeData ->{
//                    return modelMapper.map(officeData, AvailabilityDTO.class);
//                })
//                .collect(Collectors.toList());
//    }


}
