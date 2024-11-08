package com.application.eventsbooking.dto;

import com.application.eventsbooking.validations.ValidDateRange;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class DateDTO {

    private int id;

    @NotNull(message = "Date cannot be empty")
    @ValidDateRange
    private LocalDateTime date;
}
