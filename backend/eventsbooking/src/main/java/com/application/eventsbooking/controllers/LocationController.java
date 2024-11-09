package com.application.eventsbooking.controllers;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.dto.LocationDTO;
import com.application.eventsbooking.factory.ApiResponseFactory;
import com.application.eventsbooking.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO<LocationDTO>> addLocation(@Valid @RequestBody LocationDTO locationDTO) {

        LocationDTO responseDTO = locationService.addLocation(locationDTO);

        return ApiResponseFactory.created(responseDTO, "Location added successfully.");
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseDTO<List<LocationDTO>>> getAllLocations() {

        List<LocationDTO> responseDTO = locationService.getAllLocations();

        return ApiResponseFactory.success(responseDTO, "Locations retrieved successfully.");
    }
}
