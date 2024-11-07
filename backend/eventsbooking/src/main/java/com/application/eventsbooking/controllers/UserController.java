package com.application.eventsbooking.controllers;

import com.application.eventsbooking.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        if (id == null) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        // Retrieve and return user details (example code here)
        return "User details";
    }
}
