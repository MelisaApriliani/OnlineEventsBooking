package com.application.eventsbooking.services;

import com.application.eventsbooking.models.Event;
import com.application.eventsbooking.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public List<Event> getEventsByCompany(int companyId) {
        return eventRepository.findByCompany_Id(companyId);
    }

    @Override
    public List<Event> getEventsByVendor(int vendorId) {
        return eventRepository.findByVendor_Id(vendorId);
    }
}
