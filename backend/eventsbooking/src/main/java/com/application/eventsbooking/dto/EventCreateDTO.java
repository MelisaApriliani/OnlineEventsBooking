package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

public class EventCreateDTO extends EventBaseDTO {

    @Getter
    @Setter
    private List<DateDTO> eventDate;
}
