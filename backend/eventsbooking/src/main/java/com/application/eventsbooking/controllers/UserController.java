package com.application.eventsbooking.controllers;

import com.application.eventsbooking.exception.UserNotFoundException;
import com.application.eventsbooking.factory.BusinessEntityFactory;
import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.User;
import com.application.eventsbooking.services.BusinessEntityService;
import com.application.eventsbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final BusinessEntityFactory businessEntityFactory;
    private final UserService userService;

    @Autowired
    public UserController(BusinessEntityFactory businessEntityFactory, UserService userService) {
        this.businessEntityFactory = businessEntityFactory;
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        if (id <= 0) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        // Retrieve and return user details (example code here)
        return "User details";
    }

    @GetMapping("/user/details/{id}")
    public String getUserDetails(@PathVariable int id) {
        if (id <= 0) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        User user = userService.getUserById(id);

        BusinessEntityService businessEntityService = businessEntityFactory.getBusinessEntityService(user);


        BusinessEntity businessDetails = businessEntityService.getBusinessEntityByUserId(id);
//        return ResponseEntity.ok("businessDetails.");
        // Retrieve and return user details (example code here)
        return "User details";
    }
}
