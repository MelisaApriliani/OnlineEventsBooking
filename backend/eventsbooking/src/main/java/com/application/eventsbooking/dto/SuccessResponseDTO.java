package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuccessResponseDTO<T extends DataDTO> extends ApiResponseDTO {
    private String message;

    private T data;

    public SuccessResponseDTO(int status, String message, T data) {
        super(status);
        this.message = message;
        this.data = data;
    }
}
