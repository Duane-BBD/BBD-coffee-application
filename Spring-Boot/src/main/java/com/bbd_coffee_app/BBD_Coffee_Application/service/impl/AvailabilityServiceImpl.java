package com.bbd_coffee_app.BBD_Coffee_Application.service.impl;

import com.bbd_coffee_app.BBD_Coffee_Application.DTO.AvailabilityDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Availability;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Office;
import com.bbd_coffee_app.BBD_Coffee_Application.model.Product;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.AvailabilityRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.OfficeRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.repository.ProductRepository;
import com.bbd_coffee_app.BBD_Coffee_Application.service.AvailabilityService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
