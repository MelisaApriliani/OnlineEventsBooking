package com.application.eventsbooking.dto;

import java.time.LocalDate;
import java.util.List;

public class EventUpdateDTO extends EventBaseDTO{

    private int statusId;
    private String remarks;
    private List<LocalDate> eventDates;

    //TODO: remove unused proposed dates associated with this event if approved or rejected
}
