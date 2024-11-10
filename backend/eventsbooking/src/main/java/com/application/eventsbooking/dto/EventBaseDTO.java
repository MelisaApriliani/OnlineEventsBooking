package com.application.eventsbooking.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class EventBaseDTO {

    @Getter
    @Setter
    private int eventId;

    @Getter
    @Setter
    private int companyId;

    @Getter
    @Setter
    @NotNull(message = "Even name cannot be empty")
    @Size(min = 2, message = "Event name should have at least 2 characters")
    private String eventName;

    @Getter
    @Setter
    @Size(max = 100, message = "Event description must be maximum 100 characters long")
    private String description;

    @Getter
    @Setter
    private LocationDTO location;

    @Getter
    @Setter
    private LocalDate dateCreated;

}
