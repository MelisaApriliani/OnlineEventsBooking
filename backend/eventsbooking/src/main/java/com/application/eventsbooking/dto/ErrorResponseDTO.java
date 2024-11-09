package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    @Getter
    @Setter
    private int status;
    private LocalDateTime timestamp;
    private String errorCode;
    private String message;


    public ErrorResponseDTO(int status, LocalDateTime timestamp, String errorCode, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message == null ? "" : message;
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';

    }
}
