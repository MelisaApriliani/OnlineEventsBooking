package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

public class ApiResponseDTO<T extends ResponseDataDTO> {

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T data;

    public ApiResponseDTO(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
