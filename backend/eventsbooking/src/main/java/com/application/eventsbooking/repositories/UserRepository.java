package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int userId);
    Optional<User> findByUsername(String username);
}
