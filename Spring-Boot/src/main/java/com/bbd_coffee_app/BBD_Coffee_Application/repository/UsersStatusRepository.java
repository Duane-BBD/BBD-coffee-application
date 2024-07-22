package com.example.demo.repository;

import com.example.demo.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersStatusRepository extends JpaRepository<UserStatus,Integer> {
}
