package com.application.eventsbooking.dto;

import com.application.eventsbooking.validations.ValidDateRange;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateDTO {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @NotNull(message = "Date cannot be empty")
    @ValidDateRange
    private LocalDate date;
}
