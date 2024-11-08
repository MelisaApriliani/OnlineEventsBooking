package com.application.eventsbooking.services;

import com.application.eventsbooking.dto.EventCreateDTO;
import com.application.eventsbooking.dto.EventResponseDTO;
import com.application.eventsbooking.dto.EventUpdateDTO;
import com.application.eventsbooking.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    public EventResponseDTO createEvent(EventCreateDTO eventCreateDTO);
    public EventResponseDTO updateEvent(EventUpdateDTO eventUpdateDTO);
    public void deleteEvent(Event event);
    public List<EventResponseDTO> getEventsByCompany(int companyId);
    public List<EventResponseDTO> getEventsByVendor(int vendorId);
}
