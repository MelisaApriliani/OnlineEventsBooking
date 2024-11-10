package com.application.eventsbooking.controllers;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.exception.UserNotFoundException;
import com.application.eventsbooking.factory.ApiResponseFactory;
import com.application.eventsbooking.factory.BusinessEntityFactory;
import com.application.eventsbooking.models.User;
import com.application.eventsbooking.services.BusinessEntityService;
import com.application.eventsbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final BusinessEntityFactory businessEntityFactory;
    private final UserService userService;

    @Autowired
    public UserController(BusinessEntityFactory businessEntityFactory, UserService userService) {
        this.businessEntityFactory = businessEntityFactory;
        this.userService = userService;
    }

//    @GetMapping("/user/{id}")
//    public String getUserById(@PathVariable int id) {
//        if (id <= 0) {
//            throw new UserNotFoundException("User with ID " + id + " not found");
//        }
//        // Retrieve and return user details (example code here)
//        return "User details";
//    }

    @GetMapping("/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDTO<BusinessEntityDetailsDTO>> getUserDetails(@PathVariable int id) {
        if (id <= 0) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        BusinessEntityService businessEntityService = businessEntityFactory.getBusinessEntityService(user);
        BusinessEntityDetailsDTO businessDetails = businessEntityService.getBusinessEntityByUserId(id);

        return ApiResponseFactory.success(businessDetails, "User details retrieved successfully.");

    }
}
