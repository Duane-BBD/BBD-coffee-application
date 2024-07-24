package com.bbd_coffee_app.BBD_Coffee_Application.repository;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserRegisterDTO;
import org.springframework.data.jpa.repository.Query;
import com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOfficeDTO;
import com.bbd_coffee_app.BBD_Coffee_Application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT new com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOfficeDTO(u.firstName, u.lastName, ut.userTypeValue, o.officeName) " +
            "FROM AppUser u " +
            "INNER JOIN u.userType ut " +
            "INNER JOIN u.office o")
    List<UserOfficeDTO> fetchUserDetails();

}
