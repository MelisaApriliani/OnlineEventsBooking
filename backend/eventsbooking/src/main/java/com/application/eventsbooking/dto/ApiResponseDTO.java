package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

public class ApiResponseDTO {

    @Getter
    @Setter
    private int status;



    public ApiResponseDTO(int status) {
        this.status = status;
    }

}
