package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponseDTO<T> extends ApiResponseDTO<T> {

    private String errorCode;
    private String error;
    private T data;


    public ErrorResponseDTO(int status, String errorCode, String message) {
        super(status);
        this.errorCode = errorCode;
        this.error = message == null ? "" : message;
        this.data = null;
    }

}
