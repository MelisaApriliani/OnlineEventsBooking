package com.application.eventsbooking.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 50, message = "Remarks must be maximum 50 characters long")
    private String remarks;

    @Getter
    @Setter
    private List<DateDTO> eventDates;

    //TODO: remove unused proposed dates associated with this event if approved or rejected
}
