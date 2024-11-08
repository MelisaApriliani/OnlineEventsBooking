package com.application.eventsbooking.services;

import com.application.eventsbooking.Mapper.EventMapper;
import com.application.eventsbooking.dto.EventCreateDTO;
import com.application.eventsbooking.dto.EventResponseDTO;
import com.application.eventsbooking.dto.EventUpdateDTO;
import com.application.eventsbooking.exception.ResourceNotFoundException;
import com.application.eventsbooking.models.Event;
import com.application.eventsbooking.models.EventDate;
import com.application.eventsbooking.models.EventStatus;
import com.application.eventsbooking.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final LocationService locationService;


    @Autowired
    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper, LocationService locationService) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.locationService = locationService;
    }

    @Override
    public EventResponseDTO createEvent(EventCreateDTO eventCreateDTO) {
        EventResponseDTO eventResponseDTO;

        try {
            Event event = eventMapper.toEvenEntity(eventCreateDTO);

            //if the location is not in DB, then save it to DB
            if(eventCreateDTO.getLocation() != null && eventCreateDTO.getLocation().getId() <= 0) {
                locationService.addLocation(eventCreateDTO.getLocation());
            }

            Event createdEvent = eventRepository.save(event);
            if(createdEvent == null) {
                throw new RuntimeException("Error while creating event");
            }

            eventResponseDTO = eventMapper.toResponseDTO(createdEvent);
        }catch (Exception e){
            throw new RuntimeException("Error while creating event");
        }

        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO updateEvent(EventUpdateDTO eventUpdateDTO) {
        Event eventEntity = eventRepository.findById(eventUpdateDTO.getEventId());

        if(eventEntity == null) {
            throw new ResourceNotFoundException("Event with Id not found");
        }

        eventEntity.setRemarks(eventUpdateDTO.getRemarks());
        eventEntity.setStatus(new EventStatus(eventUpdateDTO.getStatusId()));
        List<EventDate> eventDates = new ArrayList<>();
        eventDates = eventUpdateDTO.getEventDates().stream()
                .map(date -> {
                    try {
                        return eventMapper.toDateEntity(date);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Even to entity", e);
                    }
                })
                .collect(Collectors.toList());
        eventEntity.setEventDates(eventDates);

        Event updatedEvent = eventRepository.save(eventEntity);
        if(updatedEvent == null) {
            throw new RuntimeException("Error while updating event");
        }

        return eventMapper.toResponseDTO(updatedEvent);
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public List<EventResponseDTO> getEventsByCompany(int companyId) {
        List<Event> events = eventRepository.findByCompany_Id(companyId);
        if(events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        List<EventResponseDTO> eventResponseDTOS;
        eventResponseDTOS = events.stream()
                .map(event -> {
                    try {
                        return eventMapper.toResponseDTO(event);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Event to DTO", e);
                    }
                })
                .toList();

        return eventResponseDTOS;
    }

    @Override
    public List<EventResponseDTO> getEventsByVendor(int vendorId) {
        List<Event> events = eventRepository.findByVendor_Id(vendorId);
        if(events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        List<EventResponseDTO> eventResponseDTOS;
        eventResponseDTOS = events.stream()
                .map(event -> {
                    try {
                        return eventMapper.toResponseDTO(event);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Event to DTO", e);
                    }
                })
                .toList();

        return eventResponseDTOS;
    }
}
