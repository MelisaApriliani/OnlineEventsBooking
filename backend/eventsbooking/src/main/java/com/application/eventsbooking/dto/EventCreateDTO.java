package com.application.eventsbooking.dto;

import java.time.LocalDate;
import java.util.List;

public class EventCreateDTO extends EventBaseDTO {
    private List<LocalDate> eventDate;
}
