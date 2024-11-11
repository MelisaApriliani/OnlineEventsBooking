package com.application.eventsbooking.services;

import com.application.eventsbooking.Mapper.EventMapper;
import com.application.eventsbooking.Mapper.LocationMapper;
import com.application.eventsbooking.constants.AppConstants;
import com.application.eventsbooking.dto.EventCreateDTO;
import com.application.eventsbooking.dto.EventResponseDTO;
import com.application.eventsbooking.dto.EventUpdateDTO;
import com.application.eventsbooking.dto.LocationDTO;
import com.application.eventsbooking.exception.InvalidArgumentException;
import com.application.eventsbooking.exception.ResourceNotFoundException;
import com.application.eventsbooking.models.Event;
import com.application.eventsbooking.models.EventDate;
import com.application.eventsbooking.models.EventStatus;
import com.application.eventsbooking.models.Location;
import com.application.eventsbooking.repositories.EventRepository;
import com.application.eventsbooking.repositories.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final EventMapper eventMapper;
    private final LocationService locationService;
    private final LocationMapper locationMapper;


    @Autowired
    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper, LocationService locationService, LocationMapper locationMapper, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.locationService = locationService;
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }

    @Override
    public EventResponseDTO createEvent(EventCreateDTO eventCreateDTO) {
        if(eventCreateDTO.getEventDates()== null || eventCreateDTO.getEventDates().size() != 3) {
            throw new InvalidArgumentException("Event should have 3 proposed dates");
        }

        EventResponseDTO eventResponseDTO;
        try {
            Event event = eventMapper.toEvenEntity(eventCreateDTO);

            log.info("Mapped DTO to entity"+ event);

            //if the event location is not in DB, then save it to DB
            //TODO need to check in DB if the same location name and postalcode exists
            Location location;
            if(eventCreateDTO.getLocation() != null) {
                if(eventCreateDTO.getLocation().getId() <= 0) {
                    // Case 1: Location doesn't exist, create new location
                    location = locationRepository.save(locationMapper.toEntity(eventCreateDTO.getLocation()));
                    event.setLocation(location);
                } else {
                    // Case 2: Location already exists in DB, just set it
                    location = locationRepository.findById(eventCreateDTO.getLocation().getId());
                    if(location == null) {
                        throw new ResourceNotFoundException(
                        "Location with ID " + eventCreateDTO.getLocation().getId() + " not found");
                    }
                    event.setLocation(location);
                }
            }

            Event createdEvent = eventRepository.save(event);
            log.info("successfully saving event to database"+ createdEvent);

            eventResponseDTO = eventMapper.toResponseDTO(createdEvent);

        }catch (Exception e){
            throw new RuntimeException("Error while creating event");
        }

        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO updateEvent(EventUpdateDTO eventUpdateDTO) {
        if(eventUpdateDTO.getEventDates() == null || eventUpdateDTO.getEventDates().isEmpty() || eventUpdateDTO.getEventDates().size() > 3) {
            throw new InvalidArgumentException("Invalid number of event dates");
        }
        switch (eventUpdateDTO.getStatusId()){
            case AppConstants.EVENT_STATUS_APPROVED:{
                if(eventUpdateDTO.getEventDates().size() > 1) {
                    throw new InvalidArgumentException("Approved event should have only one date");
                }
                break;
            }
            case AppConstants.EVENT_STATUS_PENDING:{
                if(eventUpdateDTO.getEventDates().size() != 3) {
                    throw new InvalidArgumentException("Pending event should have 3 proposed dates");
                }
                break;
            }
            case 3:{
                if(eventUpdateDTO.getRemarks() == null || eventUpdateDTO.getRemarks().equalsIgnoreCase("")) {
                    throw new InvalidArgumentException("Remark should be provided for rejected event");
                }
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid event status");
            }
        }

        Event eventEntity = eventRepository.findById(eventUpdateDTO.getEventId());

        if(eventEntity == null) {
            throw new ResourceNotFoundException("Event with Id not found");
        }

        eventEntity.setRemarks(eventUpdateDTO.getRemarks());
        eventEntity.setStatus(new EventStatus(eventUpdateDTO.getStatusId()));

        if(eventUpdateDTO.getStatusId() == AppConstants.EVENT_STATUS_APPROVED) {
            eventEntity.getEventDates().clear();
            EventDate date = new EventDate();
            date.setId(eventUpdateDTO.getEventDates().get(0).getId());
            date.setDate(eventUpdateDTO.getEventDates().get(0).getDate());
            eventEntity.addEventDate(date);
        }

        Event updatedEvent = eventRepository.save(eventEntity);

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
