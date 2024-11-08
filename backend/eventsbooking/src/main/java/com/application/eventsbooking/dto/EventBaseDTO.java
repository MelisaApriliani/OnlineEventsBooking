package com.application.eventsbooking.dto;

import java.time.LocalDate;

public class EventBaseDTO {
    private int eventId;
    private int companyId;
    private int vendorId;
    private String eventName;
    private String description;
    private LocationDTO location;
    private LocalDate dateCreated;

}
