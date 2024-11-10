package com.application.eventsbooking.controllers;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.factory.ApiResponseFactory;
import com.application.eventsbooking.services.VendorService;
import com.application.eventsbooking.services.VendorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDTO<List<BusinessEntityDetailsDTO>>> getAllVendors() {

        List<BusinessEntityDetailsDTO> responseDTO = vendorService.getAllVendors();

        return ApiResponseFactory.success(responseDTO, "Vendors retrieved successfully.");
    }
}
