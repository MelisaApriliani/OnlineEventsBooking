package com.application.eventsbooking.dto;

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
    private int statusId;

    @Getter
    @Setter
    private String remarks;
}
