package com.application.eventsbooking.Mapper;

import com.application.eventsbooking.dto.*;
import com.application.eventsbooking.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {
    private final BusinessEntityMapper businessEntityMapper;

    @Autowired
    public EventMapper(BusinessEntityMapper businessEntityMapper) {
        this.businessEntityMapper = businessEntityMapper;
    }

    public EventResponseDTO toResponseDTO(Event event) {
        EventResponseDTO dto = new EventResponseDTO();
        dto.setEventId(event.getId());
        dto.setCompanyId(event.getCompany().getId());

        BusinessEntityDetailsDTO vendorDTO = businessEntityMapper.toDTO(event.getVendor());
        dto.setVendor(vendorDTO);
        dto.setEventName(event.getEventName());
        dto.setDescription(event.getDescription());

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(event.getLocation().getId());
        locationDTO.setName(event.getLocation().getName());
        locationDTO.setAddress(event.getLocation().getAddress());
        locationDTO.setPostalCode(event.getLocation().getPostalCode());

        dto.setLocation(locationDTO);
        dto.setDateCreated(event.getDateCreated().toLocalDate());
        dto.setEventStatus(event.getStatus());

        List<DateDTO> dates = event.getEventDates().stream()
                .map(date -> {
                    try {
                        return toDateDTO(date);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Vendor to DTO", e);
                    }
                }).toList();
        dto.setEventDates(dates);

        return dto;
    }

    public Event toEvenEntity(EventCreateDTO eventCreateDTO) {
        Event event = new Event();
        event.setCompany(new Company(eventCreateDTO.getCompanyId()));
        event.setVendor(new Vendor(eventCreateDTO.getVendorId()));
        event.setEventName(eventCreateDTO.getEventName());
        event.setDescription(eventCreateDTO.getDescription());
        event.setDateCreated(eventCreateDTO.getDateCreated().atStartOfDay());
        event.setStatus(new EventStatus(2));

        for(DateDTO dateDTO : eventCreateDTO.getEventDates()) {
            EventDate eventDate = new EventDate();
            eventDate.setDate(dateDTO.getDate());
            event.addEventDate(eventDate);
        }

        return event;
    }

    public DateDTO toDateDTO(EventDate eventDate) {
        DateDTO dto = new DateDTO();
        dto.setId(eventDate.getId());
        dto.setDate(eventDate.getDate());

        return dto;
    }

    public EventDate toDateEntity(DateDTO eventDate) {
        EventDate date = new EventDate();
        date.setDate(eventDate.getDate());

        return date;
    }
}
