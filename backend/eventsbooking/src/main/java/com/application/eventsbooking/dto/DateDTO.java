package com.application.eventsbooking.dto;

import com.application.eventsbooking.validations.ValidDateRange;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
}
