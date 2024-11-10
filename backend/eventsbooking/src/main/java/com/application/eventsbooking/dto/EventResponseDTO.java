package com.application.eventsbooking.dto;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.EventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class EventResponseDTO extends EventBaseDTO {

    @Getter
    @Setter
    private List<DateDTO> eventDates;

    @Getter
    @Setter
    private EventStatus status;

    @Getter
    @Setter
    private String remarks;

    @Getter
    @Setter
    private BusinessEntityDetailsDTO vendor;
}
