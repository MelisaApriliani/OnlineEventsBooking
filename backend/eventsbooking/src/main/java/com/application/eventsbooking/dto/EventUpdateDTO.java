package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class EventUpdateDTO extends EventBaseDTO{

    @Getter
    @Setter
    private int statusId;

    @Getter
    @Setter
    private String remarks;

    @Getter
    @Setter
    private List<DateDTO> eventDates;

    //TODO: remove unused proposed dates associated with this event if approved or rejected
}
