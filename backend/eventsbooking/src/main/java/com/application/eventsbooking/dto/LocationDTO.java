package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

public class LocationDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String postalCode;
}
