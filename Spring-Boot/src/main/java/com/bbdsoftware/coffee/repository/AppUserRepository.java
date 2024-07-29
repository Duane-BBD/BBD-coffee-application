package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.DTO.UserOfficeDTO;
import com.bbdsoftware.coffee.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT new com.bbd_coffee_app.BBD_Coffee_Application.DTO.UserOfficeDTO(u.firstName, u.lastName, ut.userTypeValue, o.officeName) " +
            "FROM AppUser u " +
            "INNER JOIN u.userType ut " +
            "INNER JOIN u.office o")
    List<UserOfficeDTO> fetchUserDetails();


}
