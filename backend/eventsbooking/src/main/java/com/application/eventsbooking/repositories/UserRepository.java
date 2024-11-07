package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int userId);
}
