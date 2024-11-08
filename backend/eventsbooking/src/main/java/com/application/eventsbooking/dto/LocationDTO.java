package com.application.eventsbooking.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class LocationDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @NotNull(message = "Location name cannot be empty")
    @Size(min = 5, max = 50, message = "Location name must be at least 5 characters long")
    private String name;

    @Getter
    @Setter
    @NotNull(message = "Address cannot be empty")
    @Size(min = 10, max = 100, message = "Location name must be at least 10 characters long")
    private String address;

    @Getter
    @Setter
    @Size(max = 10, message = "Postalcode must be maximum 10 characters long")
    @Column(name = "postal_code")
    private String postalCode;
}
