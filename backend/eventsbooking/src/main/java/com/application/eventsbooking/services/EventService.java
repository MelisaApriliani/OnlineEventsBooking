package com.application.eventsbooking.services;

import com.application.eventsbooking.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    public Event createEvent(Event event);
    public Event updateEvent(Event event);
    public void deleteEvent(Event event);
    public List<Event> getEventsByCompany(int companyId);
    public List<Event> getEventsByVendor(int vendorId);
}
