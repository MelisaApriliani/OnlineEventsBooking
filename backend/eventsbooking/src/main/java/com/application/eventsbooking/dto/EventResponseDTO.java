package com.application.eventsbooking.dto;

import com.application.eventsbooking.models.EventStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class EventResponseDTO extends EventBaseDTO {

    @Getter
    @Setter
    private List<DateDTO> eventDates;

    @Getter
    @Setter
    private EventStatus eventStatus;

    @Getter
    @Setter
    private String remarks;

    @Getter
    @Setter
    private BusinessEntityDetailsDTO vendor;
}
