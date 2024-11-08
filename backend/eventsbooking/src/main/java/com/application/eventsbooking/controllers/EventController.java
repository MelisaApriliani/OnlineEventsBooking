package com.application.eventsbooking.controllers;

import com.application.eventsbooking.dto.*;
import com.application.eventsbooking.exception.ResourceNotFoundException;
import com.application.eventsbooking.exception.UserNotFoundException;
import com.application.eventsbooking.factory.ApiResponseFactory;
import com.application.eventsbooking.models.User;
import com.application.eventsbooking.services.BusinessEntityService;
import com.application.eventsbooking.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<EventResponseDTO>> getEventDetails(@PathVariable int id) {
        if (id <= 0) {
            throw new ResourceNotFoundException("Event with ID " + id + " not found");
        }

//        EventResponseDTO responseDTO = eventService.geEventById(id);

        return ApiResponseFactory.success(null, "Event details retrieved successfully.");
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<ApiResponseDTO<List<EventResponseDTO>>> getEventDetailsbyCompany(@PathVariable int id) {
        if (id <= 0) {
            throw new ResourceNotFoundException("Event with company ID " + id + " not found.");
        }

        List<EventResponseDTO> responseDTO = eventService.getEventsByCompany(id);

        return ApiResponseFactory.success(responseDTO, "Event details list retrieved successfully.");
    }

    @GetMapping("/vendor/{id}")
    public ResponseEntity<ApiResponseDTO<List<EventResponseDTO>>> getEventDetailsbyVendor(@PathVariable int id) {
        if (id <= 0) {
            throw new ResourceNotFoundException("Event with vendor ID " + id + " not found.");
        }

        List<EventResponseDTO> responseDTO = eventService.getEventsByVendor(id);

        return ApiResponseFactory.success(responseDTO, "Event details list retrieved successfully.");
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO<EventResponseDTO>> addEvent(@Valid @RequestBody EventCreateDTO eventCreateDTO) {

        EventResponseDTO responseDTO = eventService.createEvent(eventCreateDTO);

        return ApiResponseFactory.created(responseDTO, "Event created successfully.");
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDTO<EventResponseDTO>> updateEvent(@Valid @RequestBody EventUpdateDTO eventUpdateDTO) {

        EventResponseDTO responseDTO = eventService.updateEvent(eventUpdateDTO);

        return ApiResponseFactory.success(responseDTO, "Event updated successfully.");
    }
}
