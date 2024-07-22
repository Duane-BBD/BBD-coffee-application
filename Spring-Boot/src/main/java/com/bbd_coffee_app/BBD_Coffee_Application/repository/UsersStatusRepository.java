package com.bbd_coffee_app.BBD_Coffee_Application.repository;

import com.example.demo.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersStatusRepository extends JpaRepository<UserStatus,Integer> {
}
