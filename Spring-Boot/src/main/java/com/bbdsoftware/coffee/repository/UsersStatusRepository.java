package com.bbdsoftware.coffee.repository;

import com.bbdsoftware.coffee.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersStatusRepository extends JpaRepository<UserStatus,Integer> {
}
